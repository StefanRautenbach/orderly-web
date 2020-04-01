/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db;


import javax.annotation.Generated;

import org.vaccineimpact.orderlyweb.db.tables.ArtefactFormat;
import org.vaccineimpact.orderlyweb.db.tables.Changelog;
import org.vaccineimpact.orderlyweb.db.tables.ChangelogLabel;
import org.vaccineimpact.orderlyweb.db.tables.CustomFields;
import org.vaccineimpact.orderlyweb.db.tables.Data;
import org.vaccineimpact.orderlyweb.db.tables.Depends;
import org.vaccineimpact.orderlyweb.db.tables.File;
import org.vaccineimpact.orderlyweb.db.tables.FileArtefact;
import org.vaccineimpact.orderlyweb.db.tables.FileInput;
import org.vaccineimpact.orderlyweb.db.tables.FileInputGlobal;
import org.vaccineimpact.orderlyweb.db.tables.FilePurpose;
import org.vaccineimpact.orderlyweb.db.tables.OrderlySchema;
import org.vaccineimpact.orderlyweb.db.tables.OrderlySchemaTables;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebDocument;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebPinnedReportGlobal;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebReportTag;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebReportVersionTag;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebSettings;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUser;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroup;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupGlobalPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupPermissionAll;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupReportPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupUser;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupVersionPermission;
import org.vaccineimpact.orderlyweb.db.tables.Parameters;
import org.vaccineimpact.orderlyweb.db.tables.ParametersType;
import org.vaccineimpact.orderlyweb.db.tables.Report;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersion;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionArtefact;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionCustomFields;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionData;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionPackage;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionTag;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionView;
import org.vaccineimpact.orderlyweb.db.tables.Tag;


/**
 * Convenience access to all tables in 
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>artefact_format</code>.
     */
    public static final ArtefactFormat ARTEFACT_FORMAT = org.vaccineimpact.orderlyweb.db.tables.ArtefactFormat.ARTEFACT_FORMAT;

    /**
     * The table <code>changelog</code>.
     */
    public static final Changelog CHANGELOG = org.vaccineimpact.orderlyweb.db.tables.Changelog.CHANGELOG;

    /**
     * The table <code>changelog_label</code>.
     */
    public static final ChangelogLabel CHANGELOG_LABEL = org.vaccineimpact.orderlyweb.db.tables.ChangelogLabel.CHANGELOG_LABEL;

    /**
     * The table <code>custom_fields</code>.
     */
    public static final CustomFields CUSTOM_FIELDS = org.vaccineimpact.orderlyweb.db.tables.CustomFields.CUSTOM_FIELDS;

    /**
     * The table <code>data</code>.
     */
    public static final Data DATA = org.vaccineimpact.orderlyweb.db.tables.Data.DATA;

    /**
     * The table <code>depends</code>.
     */
    public static final Depends DEPENDS = org.vaccineimpact.orderlyweb.db.tables.Depends.DEPENDS;

    /**
     * The table <code>file</code>.
     */
    public static final File FILE = org.vaccineimpact.orderlyweb.db.tables.File.FILE;

    /**
     * The table <code>file_artefact</code>.
     */
    public static final FileArtefact FILE_ARTEFACT = org.vaccineimpact.orderlyweb.db.tables.FileArtefact.FILE_ARTEFACT;

    /**
     * The table <code>file_input</code>.
     */
    public static final FileInput FILE_INPUT = org.vaccineimpact.orderlyweb.db.tables.FileInput.FILE_INPUT;

    /**
     * The table <code>file_input_global</code>.
     */
    public static final FileInputGlobal FILE_INPUT_GLOBAL = org.vaccineimpact.orderlyweb.db.tables.FileInputGlobal.FILE_INPUT_GLOBAL;

    /**
     * The table <code>file_purpose</code>.
     */
    public static final FilePurpose FILE_PURPOSE = org.vaccineimpact.orderlyweb.db.tables.FilePurpose.FILE_PURPOSE;

    /**
     * The table <code>orderly_schema</code>.
     */
    public static final OrderlySchema ORDERLY_SCHEMA = org.vaccineimpact.orderlyweb.db.tables.OrderlySchema.ORDERLY_SCHEMA;

    /**
     * The table <code>orderly_schema_tables</code>.
     */
    public static final OrderlySchemaTables ORDERLY_SCHEMA_TABLES = org.vaccineimpact.orderlyweb.db.tables.OrderlySchemaTables.ORDERLY_SCHEMA_TABLES;

    /**
     * The table <code>orderlyweb_document</code>.
     */
    public static final OrderlywebDocument ORDERLYWEB_DOCUMENT = org.vaccineimpact.orderlyweb.db.tables.OrderlywebDocument.ORDERLYWEB_DOCUMENT;

    /**
     * The table <code>orderlyweb_permission</code>.
     */
    public static final OrderlywebPermission ORDERLYWEB_PERMISSION = org.vaccineimpact.orderlyweb.db.tables.OrderlywebPermission.ORDERLYWEB_PERMISSION;

    /**
     * The table <code>orderlyweb_pinned_report_global</code>.
     */
    public static final OrderlywebPinnedReportGlobal ORDERLYWEB_PINNED_REPORT_GLOBAL = org.vaccineimpact.orderlyweb.db.tables.OrderlywebPinnedReportGlobal.ORDERLYWEB_PINNED_REPORT_GLOBAL;

    /**
     * The table <code>orderlyweb_report_tag</code>.
     */
    public static final OrderlywebReportTag ORDERLYWEB_REPORT_TAG = org.vaccineimpact.orderlyweb.db.tables.OrderlywebReportTag.ORDERLYWEB_REPORT_TAG;

    /**
     * The table <code>orderlyweb_report_version_tag</code>.
     */
    public static final OrderlywebReportVersionTag ORDERLYWEB_REPORT_VERSION_TAG = org.vaccineimpact.orderlyweb.db.tables.OrderlywebReportVersionTag.ORDERLYWEB_REPORT_VERSION_TAG;

    /**
     * The table <code>orderlyweb_settings</code>.
     */
    public static final OrderlywebSettings ORDERLYWEB_SETTINGS = org.vaccineimpact.orderlyweb.db.tables.OrderlywebSettings.ORDERLYWEB_SETTINGS;

    /**
     * The table <code>orderlyweb_user</code>.
     */
    public static final OrderlywebUser ORDERLYWEB_USER = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUser.ORDERLYWEB_USER;

    /**
     * The table <code>orderlyweb_user_group</code>.
     */
    public static final OrderlywebUserGroup ORDERLYWEB_USER_GROUP = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroup.ORDERLYWEB_USER_GROUP;

    /**
     * The table <code>orderlyweb_user_group_global_permission</code>.
     */
    public static final OrderlywebUserGroupGlobalPermission ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupGlobalPermission.ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION;

    /**
     * The table <code>orderlyweb_user_group_permission</code>.
     */
    public static final OrderlywebUserGroupPermission ORDERLYWEB_USER_GROUP_PERMISSION = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupPermission.ORDERLYWEB_USER_GROUP_PERMISSION;

    /**
     * The table <code>orderlyweb_user_group_permission_all</code>.
     */
    public static final OrderlywebUserGroupPermissionAll ORDERLYWEB_USER_GROUP_PERMISSION_ALL = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupPermissionAll.ORDERLYWEB_USER_GROUP_PERMISSION_ALL;

    /**
     * The table <code>orderlyweb_user_group_report_permission</code>.
     */
    public static final OrderlywebUserGroupReportPermission ORDERLYWEB_USER_GROUP_REPORT_PERMISSION = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupReportPermission.ORDERLYWEB_USER_GROUP_REPORT_PERMISSION;

    /**
     * The table <code>orderlyweb_user_group_user</code>.
     */
    public static final OrderlywebUserGroupUser ORDERLYWEB_USER_GROUP_USER = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupUser.ORDERLYWEB_USER_GROUP_USER;

    /**
     * The table <code>orderlyweb_user_group_version_permission</code>.
     */
    public static final OrderlywebUserGroupVersionPermission ORDERLYWEB_USER_GROUP_VERSION_PERMISSION = org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupVersionPermission.ORDERLYWEB_USER_GROUP_VERSION_PERMISSION;

    /**
     * The table <code>parameters</code>.
     */
    public static final Parameters PARAMETERS = org.vaccineimpact.orderlyweb.db.tables.Parameters.PARAMETERS;

    /**
     * The table <code>parameters_type</code>.
     */
    public static final ParametersType PARAMETERS_TYPE = org.vaccineimpact.orderlyweb.db.tables.ParametersType.PARAMETERS_TYPE;

    /**
     * The table <code>report</code>.
     */
    public static final Report REPORT = org.vaccineimpact.orderlyweb.db.tables.Report.REPORT;

    /**
     * The table <code>report_version</code>.
     */
    public static final ReportVersion REPORT_VERSION = org.vaccineimpact.orderlyweb.db.tables.ReportVersion.REPORT_VERSION;

    /**
     * The table <code>report_version_artefact</code>.
     */
    public static final ReportVersionArtefact REPORT_VERSION_ARTEFACT = org.vaccineimpact.orderlyweb.db.tables.ReportVersionArtefact.REPORT_VERSION_ARTEFACT;

    /**
     * The table <code>report_version_custom_fields</code>.
     */
    public static final ReportVersionCustomFields REPORT_VERSION_CUSTOM_FIELDS = org.vaccineimpact.orderlyweb.db.tables.ReportVersionCustomFields.REPORT_VERSION_CUSTOM_FIELDS;

    /**
     * The table <code>report_version_data</code>.
     */
    public static final ReportVersionData REPORT_VERSION_DATA = org.vaccineimpact.orderlyweb.db.tables.ReportVersionData.REPORT_VERSION_DATA;

    /**
     * The table <code>report_version_package</code>.
     */
    public static final ReportVersionPackage REPORT_VERSION_PACKAGE = org.vaccineimpact.orderlyweb.db.tables.ReportVersionPackage.REPORT_VERSION_PACKAGE;

    /**
     * The table <code>report_version_tag</code>.
     */
    public static final ReportVersionTag REPORT_VERSION_TAG = org.vaccineimpact.orderlyweb.db.tables.ReportVersionTag.REPORT_VERSION_TAG;

    /**
     * The table <code>report_version_view</code>.
     */
    public static final ReportVersionView REPORT_VERSION_VIEW = org.vaccineimpact.orderlyweb.db.tables.ReportVersionView.REPORT_VERSION_VIEW;

    /**
     * The table <code>tag</code>.
     */
    public static final Tag TAG = org.vaccineimpact.orderlyweb.db.tables.Tag.TAG;
}
