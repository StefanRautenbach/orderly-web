import {mount} from '@vue/test-utils';
import GlobalReadersList from "../../../js/components/reports/globalReportReadersList.vue";
import {mockAxios} from "../../mockAxios";

describe("globalReadersList", () => {

    beforeEach(() => {
        mockAxios.reset();
        mockAxios.onGet('http://app/user-groups/report-readers/')
            .reply(200, {"data": mockRoles});
    });

    const mockRoles =  [
        {
            name: "Funders",
            members: [
                {
                    email: "user1@example.com",
                    username: "user1",
                    display_name: "User One",
                    can_remove: false
                }
            ]
        },
        {
            name: "test.user@example.com",
            members: []
        }
    ];

    const mappedRoles =  [
        {
            name: "Funders",
            members: [
                {
                    email: "user1@example.com",
                    username: "user1",
                    display_name: "User One",
                    can_remove: false
                }
            ],
            hasChildren: true
        },
        {
            name: "test.user@example.com",
            members: [],
            hasChildren: false
        }
    ];

    it('fetches readers on mount', (done) => {

        const wrapper = mount(GlobalReadersList);

        setTimeout(() => {
            expect(mockAxios.history.get.length).toBe(1);
            expect(wrapper.vm.$data["readers"]).toEqual(expect.arrayContaining(mappedRoles));
            done();
        });
    });

    it('renders roles', () => {

        const wrapper = mount(GlobalReadersList);
        wrapper.setData({
            readers: mappedRoles
        });

        expect(wrapper.find('label').text()).toContain("Global read access");
        expect(wrapper.find('label').find("a").text()).toBe("Edit roles");

        const roles = wrapper.findAll("ul.roles > li");
        expect(roles.length).toBe(2);
    });

    it('renders roles with members', () => {

        const wrapper = mount(GlobalReadersList);
        wrapper.setData({
            readers: mappedRoles
        });

        const roles = wrapper.findAll("ul.roles > li");
        const roleWithMembers = roles.at(0);

        expect(roleWithMembers.classes("open")).toBe(false);
        expect(roleWithMembers.classes("has-children")).toBe(true);
        expect(roleWithMembers.find(".role-name").text()).toBe("Funders");

    });

    it('can expand and collapse members', () => {

        const wrapper = mount(GlobalReadersList);
        wrapper.setData({
            readers: mappedRoles
        });

        const roles = wrapper.findAll("ul.roles > li");
        const roleWithMembers = roles.at(0);

        const membersList = roleWithMembers.find("ul");

        expect(membersList.isVisible()).toBe(false);
        expect(roleWithMembers.classes("open")).toBe(false);

        roleWithMembers.trigger("click");

        expect(membersList.isVisible()).toBe(true);
        expect(roleWithMembers.classes("open")).toBe(true);

        const members = membersList.findAll("li");
        expect(members.length).toBe(1);
        expect(members.at(0).find(".reader-display-name").text()).toBe("User One");
        expect(members.at(0).find(".text-muted.small.email").text()).toBe("user1@example.com");

        roleWithMembers.trigger("click");

        expect(membersList.isVisible()).toBe(false);
        expect(roleWithMembers.classes("open")).toBe(false);
    });

    it('renders identity roles', () => {

        const wrapper = mount(GlobalReadersList);
        wrapper.setData({
            readers: mappedRoles
        });

        const roles = wrapper.findAll("ul.roles > li");
        const roleWithMembers = roles.at(1);

        expect(roleWithMembers.classes("has-children")).toBe(false);
        expect(roleWithMembers.find(".role-name").text()).toBe("test.user@example.com");
        expect(roleWithMembers.findAll("ul").length).toBe(0);

    });

});