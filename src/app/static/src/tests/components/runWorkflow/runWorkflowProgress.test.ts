import {shallowMount} from "@vue/test-utils";
import runWorkflowProgress from '../../../js/components/runWorkflow/runWorkflowProgress.vue'

describe(`runWorkflowProgress`, () => {

    const getWrapper = () => {
        return shallowMount(runWorkflowProgress, {propsData: {workflowMetadata: {}}})
    }

    it(`it can render runWorkflowProgress page`, () => {
        const wrapper = getWrapper()
        expect(wrapper.find("p").text()).toBe("Run workflow progress is coming soon")
    })

    it(`it can set and render props correctly`, async() => {
        const workflowMeta = {placeholder: "test placeholder"}
        const wrapper = getWrapper()
        await wrapper.setProps({workflowMetadata: workflowMeta})
        expect(wrapper.vm.$props.workflowMetadata).toBe(workflowMeta)
    })
})