<template>
    <div v-if="canEdit || allTags.length>0" id="tags">Tags:
        <span v-for="tag in allTags" :key="tag" class="badge badge-primary mr-1">{{ tag }}</span>
        <a v-if="canEdit" href="#" class="small" @click="editTags">
            <edit-icon></edit-icon>
            Edit tags
        </a>
        <error-info :default-message="defaultMessage" :api-error="error"></error-info>

        <div id="edit-tags" :class="['modal-background', {'modal-hide':!showModal}, {'modal-show':showModal}]">
            <div class="modal-main" style="width: 55rem">
                <div class="border-bottom p-3">
                    <h5>Edit tags</h5>
                </div>
                <div class="mb-2 p-3">
                    <tag-list id="version-tags" v-model="editedVersionTags"
                              class="mr-3 tag-list"
                              header="Report Version Tags"
                              description="These tags only apply to this version"
                              :editable="true">
                    </tag-list>
                    <tag-list id="report-tags" v-model="editedReportTags"
                              class="mr-3 tag-list"
                              header="Report Tags"
                              description="Warning: Editing these tags will change them for all versions of this report"
                              :editable="true">
                    </tag-list>
                    <tag-list id="orderly-tags" v-model="tags.orderly_tags"
                              class="tag-list"
                              header="Orderly Tags"
                              description="These are set in Orderly and cannot be changed"
                              :editable="false">
                    </tag-list>
                    <div class="clearfix"></div>
                </div>
                <div class="modal-buttons mb-3">
                    <button id="cancel-edit-btn" class="btn btn-default" @click="hideModal">
                        Cancel
                    </button>
                    <button id="save-tags-btn" class="btn submit mr-3" @click="saveTags">
                        Save changes
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import Vue from "vue";
    import {api} from "../../utils/api";
    import EditIcon from "./editIcon";
    import TagList from "./tagList";
    import ErrorInfo from "../errorInfo";

    export default Vue.extend({
        components: {
            EditIcon,
            TagList,
            ErrorInfo
        },
        props: ['report', 'canEdit'],
        data() {
            return {
                tags: {
                    version_tags: [],
                    report_tags: [],
                    orderly_tags: []
                },
                showModal: false,
                editedVersionTags: [],
                editedReportTags: [],
                error: "",
                defaultMessage: "",
            }
        },
        computed: {
            allTags: function () {
                const all = [...this.tags.version_tags, ...this.tags.report_tags, ...this.tags.orderly_tags];
                return [...new Set(all)].sort();
            }
        },
        mounted() {
            this.refreshTags()
        },
        methods: {
            editTags: function () {
                this.editedVersionTags = [...this.tags.version_tags];
                this.editedReportTags = [...this.tags.report_tags];
                this.showModal = true;
            },
            hideModal: function () {
                this.showModal = false;
            },
            saveTags: function () {
                this.error = "";
                this.defaultMessage = "";
                this.hideModal();

                const data = {
                    version_tags: this.editedVersionTags,
                    report_tags: this.editedReportTags
                };
                api.post(`/report/${this.report.name}/version/${this.report.id}/update-tags/`, data)
                    .then(() => {
                        this.refreshTags();
                    })
                    .catch((error) => {
                        this.error = error;
                        this.defaultMessage = "An error occurred updating tags";
                    });
            },
            refreshTags() {
                this.error = "";
                this.defaultMessage = "";
                api.get(`/report/${this.report.name}/version/${this.report.id}/tags/`)
                    .then(({data}) => {
                        this.tags = data.data;
                    })
                    .catch((error) => {
                        this.error = error;
                        this.defaultMessage = "An error occurred fetching tags";
                    });
            }
        }
    });
</script>
