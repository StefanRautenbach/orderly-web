import Vue from "vue";
import documentList from "./components/documents/documentList.vue";

new Vue({
    el: '#app',
    data: {
        docs: docs
    },
    components: {
        documentList: documentList
    }
});