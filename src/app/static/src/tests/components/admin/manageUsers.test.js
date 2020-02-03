import Vue from "vue";
import {mockAxios} from "../../mockAxios";
import {mount, shallowMount} from "@vue/test-utils";
import ManageUsers from "../../../js/components/admin/manageUsers.vue";
import PermissionList from "../../../js/components/admin/permissionList.vue";

describe("manage users", () => {

    const mockUsers = [
        {
            username: "a.user",
            display_name: "Some name",
            email: "a@example.com",
            direct_permissions: []
        },
        {
            username: "b.user",
            display_name: "Some other name",
            email: "b@example.com",
            direct_permissions: [{
                name: "reports.read",
                scope_id: "",
                scope_prefix: null
            }]
        }
    ];

    beforeEach(() => {
        mockAxios.reset();
        mockAxios.onGet('http://app/users/')
            .reply(200, {"data": mockUsers});
        mockAxios.onGet("http://app/typeahead/permissions/")
            .reply(200, {
                "data": ["reports.read", "reports.review", "users.manage"]
            });
    });

    it("fetches users on mount", (done) => {
        shallowMount(ManageUsers);

        setTimeout(() => {
            expect(mockAxios.history.get.length).toBe(1);
            done();
        });
    });

    it("matches users by case insensitive username", async () => {
        const rendered = shallowMount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("a.");
        await Vue.nextTick();
        expect(rendered.findAll("li").length).toBe(1);
        expect(rendered.find("li .role-name").text()).toBe("Some name");

        rendered.find("input").setValue("A.");
        await Vue.nextTick();
        expect(rendered.findAll("li").length).toBe(1);
        expect(rendered.find("li .role-name").text()).toBe("Some name");
    });

    it("matches users by case insensitive email", async () => {
        const rendered = shallowMount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("example");

        await Vue.nextTick();
        expect(rendered.findAll("li").length).toBe(2);

        rendered.find("input").setValue("EXAmple");
        await Vue.nextTick();
        expect(rendered.findAll("li").length).toBe(2);
    });

    it("matches users by case insensitive display name", async () => {
        const rendered = shallowMount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("other");

        await Vue.nextTick();
        expect(rendered.findAll("li").length).toBe(1);
        expect(rendered.find("li .role-name").text()).toBe("Some other name");

        rendered.find("input").setValue("Other");
        await Vue.nextTick();
        expect(rendered.findAll("li").length).toBe(1);
        expect(rendered.find("li .role-name").text()).toBe("Some other name");
    });

    it("renders permission list", async () => {
        const rendered = shallowMount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("example");

        await Vue.nextTick();

        expect(rendered.findAll("li").length).toBe(2);
        expect(rendered.findAll(PermissionList).length).toBe(2);
        expect(rendered.findAll(PermissionList).at(0).props().permissions).toBe(mockUsers[0].direct_permissions);
        expect(rendered.findAll(PermissionList).at(1).props().permissions).toBe(mockUsers[1].direct_permissions);

        expect(rendered.findAll("li").at(0).classes("has-children")).toBe(true);
        expect(rendered.findAll("li").at(1).classes("has-children")).toBe(true);
    });

    it("can open and close permission list", async () => {
        const rendered = shallowMount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("other");

        await Vue.nextTick();

        expect(rendered.find("li").classes()).not.toContain("open");
        expect(rendered.find(PermissionList).isVisible()).toBe(false);
        rendered.find(".expander").trigger("click");

        await Vue.nextTick();

        expect(rendered.find("li").classes()).toContain("open");
        expect(rendered.find(PermissionList).isVisible()).toBe(true);
    });

    it("can remove permission", async (done) => {
        mockAxios.onDelete('http://app/users/b%40example.com/permissions/reports.read/')
            .reply(200);

        const rendered = mount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("other");

        await Vue.nextTick();

        rendered.find(".expander").trigger("click");

        await Vue.nextTick();

        rendered.find(".remove").trigger("click");

        setTimeout(() => {
            expect(mockAxios.history.delete.length).toBe(1);

            expect(rendered.findAll(".remove").length).toBe(0);
            done();
        })

    });

    it("sets error if removing permission fails", async (done) => {
        mockAxios.onDelete('http://app/users/b%40example.com/permissions/reports.read/')
            .reply(500);

        const rendered = mount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("other");

        await Vue.nextTick();

        rendered.find(".expander").trigger("click");

        await Vue.nextTick();

        rendered.find(".remove").trigger("click");

        setTimeout(() => {
            expect(rendered.find(".text-danger").text())
                .toBe("Error: could not remove reports.read from b@example.com");
            done();
        });
    });

    it("can add permission", async (done) => {
        mockAxios.onPost('http://app/users/b%40example.com/permissions/')
            .reply(200);

        const rendered = mount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("other");

        await Vue.nextTick();

        rendered.find(".expander").trigger("click");

        await Vue.nextTick();

        expect(rendered.findAll(".name").length).toBe(1);
        expect(rendered.findAll(".name").at(0).text()).toBe("reports.read");

        rendered.findAll("input").at(1).setValue("reports.review");

        await Vue.nextTick();

        rendered.find("button").trigger("click");

        setTimeout(() => {
            expect(mockAxios.history.post.length).toBe(1);
            expect(rendered.findAll(".name").length).toBe(2);
            expect(rendered.findAll(".name").at(0).text()).toBe("reports.read");
            expect(rendered.findAll(".name").at(1).text()).toBe("reports.review");
            done();
        });
    });

    it("sets error if adding permission fails", async (done) => {
        mockAxios.onPost('http://app/users/b%40example.com/permissions/')
            .reply(500);

        const rendered = mount(ManageUsers);
        rendered.setData({allUsers: mockUsers});
        rendered.find("input").setValue("other");

        await Vue.nextTick();

        rendered.find(".expander").trigger("click");

        await Vue.nextTick();

        expect(rendered.findAll(".name").length).toBe(1);
        expect(rendered.findAll(".name").at(0).text()).toBe("reports.read");

        rendered.findAll("input").at(1).setValue("reports.review");

        await Vue.nextTick();

        rendered.find("button").trigger("click");

        setTimeout(() => {
            expect(rendered.find(".text-danger").text())
                .toBe("Error: could not add reports.review to b@example.com");
            done();
            done();
        });
    });
});