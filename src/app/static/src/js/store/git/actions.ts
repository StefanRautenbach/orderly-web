import {ActionContext, ActionTree} from "vuex";
import {GitState} from "./git";
import {api} from "../../utils/api";
import {GitMutation} from "./mutations";
import {RunnerRootState} from "../../utils/types";
import {ReportsAction} from "../reports/actions";

export enum GitAction {
    FetchMetadata = "FetchMetadata",
    SelectBranch = "SelectBranch",
}

type GitActionHandler<T> = (store: ActionContext<GitState, RunnerRootState>, payload: T) => void

export const actions: ActionTree<GitState, RunnerRootState> & Record<GitAction, GitActionHandler<any>> = {

    async [GitAction.FetchMetadata](context) {
        await api.get('/report/run-metadata')
            .then(({data}) => {
                context.commit(GitMutation.SetMetadata, data.data)
                const {branches} = context.state
                let {selectedBranch} = context.state
                if (branches.length && !branches.some(branch => branch === selectedBranch)) {
                    selectedBranch = branches[0]
                }
                if (!branches.length) {
                    selectedBranch = ""
                }
                if (selectedBranch !== context.state.selectedBranch) {
                    context.dispatch('SelectBranch', selectedBranch)
                }
            })
    },

    async [GitAction.SelectBranch](context, selectedBranch: string) {
        const {rootState, commit, dispatch} = context

        commit(GitMutation.SelectBranch, selectedBranch)
        if (selectedBranch) {
            await api.get(`/git/branch/${selectedBranch}/commits/`)
                .then(({data}) => {
                    commit(GitMutation.SetCommits, data.data);

                    if (rootState.git.selectedCommit) {
                        dispatch(`reports/${ReportsAction.AvailableReports}`, false, {root: true})
                    }
                })
        }
    },
}
