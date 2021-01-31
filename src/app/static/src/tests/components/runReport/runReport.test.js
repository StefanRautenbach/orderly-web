import Vue from "vue";
import {shallowMount, mount} from "@vue/test-utils";
import RunReport from "../../../js/components/runReport/runReport.vue";
import ReportList from "../../../js/components/runReport/reportList.vue";
import ErrorInfo from "../../../js/components/errorInfo";
import {mockAxios} from "../../mockAxios";

describe("runReport", () => {
    beforeEach(() => {
        mockAxios.reset();
        mockAxios.onGet('http://app/git/branch/master/commits/')
            .reply(200, {"data": gitCommits});
    });

    const gitCommits = [
        {id: "abcdef", date_time: "Mon Jun 08, 12:01"},
        {id: "abc123", date_time: "Tue Jun 09, 13:11"}
    ];

    const gitBranches = ["master", "dev"];

    const reports = [
        {name: "report1", date: new Date().toISOString()},
        {name: "report2", date: null}
    ];

    const getWrapper = (reports) => {
        mockAxios.onGet('http://app/reports/runnable/?branch=master&commit=abcdef')
            .reply(200, {"data": reports});

        return mount(RunReport, {
            propsData: {
                metadata: {
                    git_supported: true,
                    instances_supported: false
                },
                gitBranches
            }
        });
    }

    it("renders git branch drop down and fetches commits if git supported", (done) => {

        const wrapper = shallowMount(RunReport, {
            propsData: {
                metadata: {git_supported: true, instances_supported: false},
                gitBranches
            }
        });

        expect(wrapper.find("#git-branch-form-group").exists()).toBe(true);
        const options = wrapper.findAll("#git-branch-form-group select option");
        expect(options.length).toBe(2);
        expect(options.at(0).text()).toBe("master");
        expect(options.at(0).attributes().value).toBe("master");
        expect(options.at(1).text()).toBe("dev");
        expect(options.at(1).attributes().value).toBe("dev");

        setTimeout(() => {
            expect(wrapper.find("#git-commit-form-group").exists()).toBe(true);
            const commitOptions = wrapper.findAll("#git-commit option");
            expect(commitOptions.length).toBe(2);
            expect(commitOptions.at(0).text()).toBe("abcdef (Mon Jun 08, 12:01)");
            expect(commitOptions.at(1).text()).toBe("abc123 (Tue Jun 09, 13:11)");

            expect(wrapper.vm.selectedCommitId).toBe("abcdef");
            done();
        })
    });

    it("does not render git drop downs if git not supported", async () => {
        const wrapper = shallowMount(RunReport, {
            propsData: {
                metadata: {git_supported: false, instances_supported: false},
                gitBranches: null
            }
        });

        await Vue.nextTick();
        expect(mockAxios.history.get.length).toBe(1);
        expect(wrapper.find("#git-branch-form-group").exists()).toBe(false);
        expect(wrapper.find("#git-commit-form-group").exists()).toBe(false);
    });

    it("calls api to get commits when branch changes and updates commits drop down", (done) => {
        mockAxios.onGet('http://app/git/branch/dev/commits/')
            .reply(200, {"data": gitCommits});
        mockAxios.onGet('http://app/reports/runnable/?branch=dev&commit=abcdef')
            .reply(200, {"data": []});

        const wrapper = mount(RunReport, {
            propsData: {
                metadata: {git_supported: true, instances_supported: false},
                gitBranches
            }
        });

        wrapper.findAll("#git-branch option").at(1).setSelected();

        expect(wrapper.vm.selectedBranch).toBe("dev");

        setTimeout(() => {
            const options = wrapper.findAll("#git-commit option");
            expect(options.length).toBe(2);
            expect(options.at(0).text()).toBe("abcdef (Mon Jun 08, 12:01)");
            expect(options.at(1).text()).toBe("abc123 (Tue Jun 09, 13:11)");

            expect(wrapper.vm.selectedCommitId).toBe("abcdef");

            expect(wrapper.find(ErrorInfo).props("apiError")).toBe("");
            expect(wrapper.find(ErrorInfo).props("defaultMessage")).toBe("");
            done();
        })
    });

    it("show error message if error getting git commits", (done) => {
        mockAxios.onGet('http://app/git/branch/master/commits/')
            .reply(500, "TEST ERROR");

        const wrapper = shallowMount(RunReport, {
            propsData: {
                metadata: {git_supported: true, instances_supported: false},
                gitBranches
            }
        });

        setTimeout(() => {
            expect(wrapper.find(ErrorInfo).props("apiError").response.data).toBe("TEST ERROR");
            expect(wrapper.find(ErrorInfo).props("defaultMessage")).toBe("An error occurred fetching Git commits");
            done();
        })
    });

    it("updates reports dropdown by calling api when commit changes", (done) => {
        const wrapper = getWrapper(reports);

        setTimeout(() => {
            expect(mockAxios.history.get.length).toBe(2);
            expect(wrapper.find(ErrorInfo).props("apiError")).toBe("");
            expect(wrapper.find(ErrorInfo).props("defaultMessage")).toBe("");
            expect(wrapper.find(ReportList).props("reports")).toEqual(expect.arrayContaining(reports));
            done();
        });
    });

    it("displays report list in order and allows selection and reset", (done) => {
        const wrapper = getWrapper(reports);

        setTimeout(async () => {
            wrapper.find(ReportList).find("a:last-of-type").trigger("click");
            expect(wrapper.vm.$data["selectedReport"]).toBe("report2");
            await Vue.nextTick();
            wrapper.find(ReportList).find("button").trigger("click");
            expect(wrapper.vm.$data["selectedReport"]).toBe("");
            done();
        });
    });

    it("shows instances if instances supported", () => {
        const wrapper = shallowMount(RunReport, {
            propsData: {
                metadata: {
                    git_supported: false,
                    instances_supported: true,
                    instances: {
                        source: ["prod", "uat"],
                        annex: ["one"],
                        another: []
                    }
                },
                gitBranches
            },
            data() {
                return {
                    selectedReport: "report1"
                }
            }
        });

        const sourceOptions = wrapper.findAll("#source option");
        expect(sourceOptions.length).toBe(2);
        expect(sourceOptions.at(0).attributes().value).toBe("prod");
        expect(sourceOptions.at(0).text()).toBe("prod");
        expect(sourceOptions.at(1).attributes().value).toBe("uat");
        expect(sourceOptions.at(1).text()).toBe("uat");

        expect(wrapper.find("#annex").exists()).toBe(false); // only 1 option so don't show
        expect(wrapper.find("#another").exists()).toBe(false); // no options so don't show
    });

    it("doesn't show instances if instances not supported", () => {
        const wrapper = shallowMount(RunReport, {
            propsData: {
                metadata: {
                    git_supported: true,
                    instances_supported: false,
                    instances: {
                        source: ["prod", "uat"],
                        annex: ["one"],
                        another: []
                    }
                },
                gitBranches
            }
        });

        expect(wrapper.find("#source").exists()).toBe(false);
        expect(wrapper.find("#annex").exists()).toBe(false);
        expect(wrapper.find("#another").exists()).toBe(false);
    });

    it("renders run button group if there is a selected report", async () => {
        const wrapper = getWrapper();
        wrapper.setData({selectedReport: "test-report"});
        await Vue.nextTick();
        const runGroup = wrapper.find("#run-form-group");
        expect(runGroup.exists()).toBe(true);
        expect(runGroup.find("button").text()).toBe("Run report");
        expect(runGroup.find("run-report-status").exists()).toBe(false);
    });

    it("does not render run button group if there is no selected report", () => {
        const wrapper = getWrapper();
        const runGroup = wrapper.find("#run-form-group");
        expect(runGroup.exists()).toBe(false);
    });

    it("clicking run buttton sends run request and displays status on success", async (done) => {
        const url = 'http://app/report/test-report/actions/run/';
        mockAxios.onPost(url, {})
            .reply(200, {data: {key: "test-key"}});
        const wrapper = getWrapper();

        setTimeout(async () => { //give the wrapper time to fetch reports
            wrapper.setData({
                selectedReport: "test-report",
                selectedCommitId: "test-commit",
                error: "test-error",
                defaultMessage: "test-msg"
            });

            await Vue.nextTick();
            wrapper.find("#run-form-group button").trigger("click");

            setTimeout(() => {
                expect(mockAxios.history.post.length).toBe(1);
                expect(mockAxios.history.post[0].url).toBe(url);
                expect(mockAxios.history.post[0].params).toStrictEqual({ref: "test-commit", instance: ""});
                expect(wrapper.find("#run-report-status").text()).toContain("Run started");
                expect(wrapper.find("#run-report-status a").text()).toBe("Check status");
                expect(wrapper.vm.runningKey).toBe("test-key");
                expect(wrapper.vm.error).toBe("");
                expect(wrapper.vm.defaultMessage).toBe("");
                done();
            });
        });
    });

    it("clicking run buttton sends run request and sets error", async (done) => {
        const url = 'http://app/report/test-report/actions/run/';
        mockAxios.onPost(url, {})
            .reply(500, "TEST ERROR");
        const wrapper = getWrapper();

        setTimeout(async () => { //give the wrapper time to fetch reports
            wrapper.setData({
                selectedReport: "test-report",
                selectedCommitId: "test-commit",
                error: "",
                defaultMessage: ""
            });

            await Vue.nextTick();
            wrapper.find("#run-form-group button").trigger("click");

            setTimeout(() => {
                expect(wrapper.find("#run-report-status").exists()).toBe(false);
                expect(wrapper.vm.runningKey).toBe("");
                expect(wrapper.vm.error.response.data).toBe("TEST ERROR");
                expect(wrapper.vm.defaultMessage).toBe("An error occurred when running report");
                done();
            });
        });
    });

    it("clicking 'Check status' sends status request and displays status on success", async (done) => {
        const url = 'http://app/report/test-report/actions/status/test-key/';
        mockAxios.onGet(url)
            .reply(200, {data: {status: "test-status"}});
        const wrapper = getWrapper();

        setTimeout(async () => { //give the wrapper time to fetch reports
            wrapper.setData({
                selectedReport: "test-report",
                runningKey: "test-key",
                error: "test-error",
                defaultMessage: "test-msg"
            });
            await Vue.nextTick();

            //Set data in two stages because runningStatus gets reset by watch on selectedReport change
            wrapper.setData({
                runningStatus: "Run started"
            });
            await Vue.nextTick();

            wrapper.find("#run-form-group a").trigger("click");

            setTimeout(() => {
                expect(mockAxios.history.get.length).toBe(3);
                expect(mockAxios.history.get[2].url).toBe(url);

                expect(wrapper.find("#run-report-status").text()).toContain("Running status: test-status");
                expect(wrapper.find("#run-report-status a").text()).toBe("Check status");
                expect(wrapper.vm.error).toBe("");
                expect(wrapper.vm.defaultMessage).toBe("");
                done();
            });
        });
    });

    it("clicking 'Check status' sends status request and displays error", async (done) => {
        const url = 'http://app/report/test-report/actions/status/test-key/';
        mockAxios.onGet(url)
            .reply(500, "TEST ERROR");
        const wrapper = getWrapper();

        setTimeout(async () => { //give the wrapper time to fetch reports
            wrapper.setData({
                selectedReport: "test-report",
                runningKey: "test-key",
                error: "test-error",
                defaultMessage: "test-msg"
            });
            await Vue.nextTick();

            //Set data in two stages because runningStatus gets reset by watch on selectedReport change
            wrapper.setData({
                runningStatus: "Run started"
            });
            await Vue.nextTick();

            wrapper.find("#run-form-group a").trigger("click");

            setTimeout(() => {
                expect(wrapper.vm.error.response.data).toBe("TEST ERROR");
                expect(wrapper.vm.defaultMessage).toBe("An error occurred when fetching report status");
                done();
            });
        });
    });

    it("changing selectedReport resets runningStatus", async () => {
        const wrapper = getWrapper();
        wrapper.setData({runningStatus: "test-status"});
        await Vue.nextTick();
        expect(wrapper.vm.runningStatus).toBe("test-status");

        wrapper.setData({selectedReport: "test-report"});
        await Vue.nextTick();
        expect(wrapper.vm.runningStatus).toBe("");
    });

    it("changing selectedInstances resets runningStatus", async () => {
        const wrapper = getWrapper();
        wrapper.setData({runningStatus: "test-status"});
        await Vue.nextTick();
        expect(wrapper.vm.runningStatus).toBe("test-status");

        wrapper.setData({selectedInstances: {source: "uat"}});
        await Vue.nextTick();
        expect(wrapper.vm.runningStatus).toBe("");
    });
});
