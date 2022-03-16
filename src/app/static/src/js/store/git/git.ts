import {RunReportMetadataDependency} from "../../utils/types";
import {Module} from "vuex";
import {mutations} from "./mutations";
import {actions} from "./actions";

export interface GitState {
    git_branches: string[],
    metadata: RunReportMetadataDependency
}

export const initialGitState = (): GitState => {
    return {
        metadata: null,
        git_branches: []
    }
};

const namespaced = true;

export const git: Module<GitState, any> = {
    namespaced,
    state: initialGitState(),
    actions,
    mutations
};
