/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db;


import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;
import org.vaccineimpact.orderlyweb.db.tables.ArtefactFormat;
import org.vaccineimpact.orderlyweb.db.tables.Changelog;
import org.vaccineimpact.orderlyweb.db.tables.ChangelogLabel;
import org.vaccineimpact.orderlyweb.db.tables.Data;
import org.vaccineimpact.orderlyweb.db.tables.Depends;
import org.vaccineimpact.orderlyweb.db.tables.File;
import org.vaccineimpact.orderlyweb.db.tables.FileArtefact;
import org.vaccineimpact.orderlyweb.db.tables.FileInput;
import org.vaccineimpact.orderlyweb.db.tables.FilePurpose;
import org.vaccineimpact.orderlyweb.db.tables.Orderly;
import org.vaccineimpact.orderlyweb.db.tables.OrderlySchema;
import org.vaccineimpact.orderlyweb.db.tables.OrderlySchemaTables;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUser;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroup;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupGlobalPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupReportPermission;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupUser;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebUserGroupVersionPermission;
import org.vaccineimpact.orderlyweb.db.tables.Parameters;
import org.vaccineimpact.orderlyweb.db.tables.ParametersType;
import org.vaccineimpact.orderlyweb.db.tables.Report;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersion;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionArtefact;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionData;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionPackage;
import org.vaccineimpact.orderlyweb.db.tables.ReportVersionView;
import org.vaccineimpact.orderlyweb.db.tables.records.ArtefactFormatRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ChangelogLabelRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ChangelogRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.DataRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.DependsRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.FileArtefactRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.FileInputRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.FilePurposeRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.FileRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlyRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlySchemaRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlySchemaTablesRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebPermissionRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserGroupGlobalPermissionRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserGroupPermissionRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserGroupRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserGroupReportPermissionRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserGroupUserRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserGroupVersionPermissionRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ParametersRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ParametersTypeRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionArtefactRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionDataRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionPackageRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionRecord;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionViewRecord;


/**
 * A class modelling foreign key relationships between tables of the <code></code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ArtefactFormatRecord> PK_ARTEFACT_FORMAT = UniqueKeys0.PK_ARTEFACT_FORMAT;
    public static final UniqueKey<ChangelogRecord> PK_CHANGELOG = UniqueKeys0.PK_CHANGELOG;
    public static final UniqueKey<ChangelogLabelRecord> PK_CHANGELOG_LABEL = UniqueKeys0.PK_CHANGELOG_LABEL;
    public static final UniqueKey<DataRecord> PK_DATA = UniqueKeys0.PK_DATA;
    public static final UniqueKey<DependsRecord> PK_DEPENDS = UniqueKeys0.PK_DEPENDS;
    public static final UniqueKey<FileRecord> PK_FILE = UniqueKeys0.PK_FILE;
    public static final UniqueKey<FileArtefactRecord> PK_FILE_ARTEFACT = UniqueKeys0.PK_FILE_ARTEFACT;
    public static final UniqueKey<FileInputRecord> PK_FILE_INPUT = UniqueKeys0.PK_FILE_INPUT;
    public static final UniqueKey<FilePurposeRecord> PK_FILE_PURPOSE = UniqueKeys0.PK_FILE_PURPOSE;
    public static final UniqueKey<OrderlyRecord> PK_ORDERLY = UniqueKeys0.PK_ORDERLY;
    public static final UniqueKey<OrderlySchemaRecord> PK_ORDERLY_SCHEMA = UniqueKeys0.PK_ORDERLY_SCHEMA;
    public static final UniqueKey<OrderlySchemaTablesRecord> PK_ORDERLY_SCHEMA_TABLES = UniqueKeys0.PK_ORDERLY_SCHEMA_TABLES;
    public static final UniqueKey<OrderlywebPermissionRecord> PK_ORDERLYWEB_PERMISSION = UniqueKeys0.PK_ORDERLYWEB_PERMISSION;
    public static final UniqueKey<OrderlywebUserRecord> PK_ORDERLYWEB_USER = UniqueKeys0.PK_ORDERLYWEB_USER;
    public static final UniqueKey<OrderlywebUserGroupRecord> PK_ORDERLYWEB_USER_GROUP = UniqueKeys0.PK_ORDERLYWEB_USER_GROUP;
    public static final UniqueKey<OrderlywebUserGroupPermissionRecord> PK_ORDERLYWEB_USER_GROUP_PERMISSION = UniqueKeys0.PK_ORDERLYWEB_USER_GROUP_PERMISSION;
    public static final UniqueKey<ParametersRecord> PK_PARAMETERS = UniqueKeys0.PK_PARAMETERS;
    public static final UniqueKey<ParametersTypeRecord> PK_PARAMETERS_TYPE = UniqueKeys0.PK_PARAMETERS_TYPE;
    public static final UniqueKey<ReportRecord> PK_REPORT = UniqueKeys0.PK_REPORT;
    public static final UniqueKey<ReportVersionRecord> PK_REPORT_VERSION = UniqueKeys0.PK_REPORT_VERSION;
    public static final UniqueKey<ReportVersionArtefactRecord> PK_REPORT_VERSION_ARTEFACT = UniqueKeys0.PK_REPORT_VERSION_ARTEFACT;
    public static final UniqueKey<ReportVersionDataRecord> PK_REPORT_VERSION_DATA = UniqueKeys0.PK_REPORT_VERSION_DATA;
    public static final UniqueKey<ReportVersionPackageRecord> PK_REPORT_VERSION_PACKAGE = UniqueKeys0.PK_REPORT_VERSION_PACKAGE;
    public static final UniqueKey<ReportVersionViewRecord> PK_REPORT_VERSION_VIEW = UniqueKeys0.PK_REPORT_VERSION_VIEW;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<ChangelogRecord, ReportVersionRecord> FK_CHANGELOG_REPORT_VERSION_2 = ForeignKeys0.FK_CHANGELOG_REPORT_VERSION_2;
    public static final ForeignKey<ChangelogRecord, ReportVersionRecord> FK_CHANGELOG_REPORT_VERSION_1 = ForeignKeys0.FK_CHANGELOG_REPORT_VERSION_1;
    public static final ForeignKey<ChangelogRecord, ChangelogLabelRecord> FK_CHANGELOG_CHANGELOG_LABEL_1 = ForeignKeys0.FK_CHANGELOG_CHANGELOG_LABEL_1;
    public static final ForeignKey<DependsRecord, ReportVersionRecord> FK_DEPENDS_REPORT_VERSION_1 = ForeignKeys0.FK_DEPENDS_REPORT_VERSION_1;
    public static final ForeignKey<DependsRecord, FileArtefactRecord> FK_DEPENDS_FILE_ARTEFACT_1 = ForeignKeys0.FK_DEPENDS_FILE_ARTEFACT_1;
    public static final ForeignKey<FileArtefactRecord, ReportVersionArtefactRecord> FK_FILE_ARTEFACT_REPORT_VERSION_ARTEFACT_1 = ForeignKeys0.FK_FILE_ARTEFACT_REPORT_VERSION_ARTEFACT_1;
    public static final ForeignKey<FileArtefactRecord, FileRecord> FK_FILE_ARTEFACT_FILE_1 = ForeignKeys0.FK_FILE_ARTEFACT_FILE_1;
    public static final ForeignKey<FileInputRecord, ReportVersionRecord> FK_FILE_INPUT_REPORT_VERSION_1 = ForeignKeys0.FK_FILE_INPUT_REPORT_VERSION_1;
    public static final ForeignKey<FileInputRecord, FileRecord> FK_FILE_INPUT_FILE_1 = ForeignKeys0.FK_FILE_INPUT_FILE_1;
    public static final ForeignKey<FileInputRecord, FilePurposeRecord> FK_FILE_INPUT_FILE_PURPOSE_1 = ForeignKeys0.FK_FILE_INPUT_FILE_PURPOSE_1;
    public static final ForeignKey<OrderlywebUserGroupGlobalPermissionRecord, OrderlywebUserGroupPermissionRecord> FK_ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1;
    public static final ForeignKey<OrderlywebUserGroupPermissionRecord, OrderlywebUserGroupRecord> FK_ORDERLYWEB_USER_GROUP_PERMISSION_ORDERLYWEB_USER_GROUP_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_PERMISSION_ORDERLYWEB_USER_GROUP_1;
    public static final ForeignKey<OrderlywebUserGroupPermissionRecord, OrderlywebPermissionRecord> FK_ORDERLYWEB_USER_GROUP_PERMISSION_ORDERLYWEB_PERMISSION_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_PERMISSION_ORDERLYWEB_PERMISSION_1;
    public static final ForeignKey<OrderlywebUserGroupReportPermissionRecord, OrderlywebUserGroupPermissionRecord> FK_ORDERLYWEB_USER_GROUP_REPORT_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_REPORT_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1;
    public static final ForeignKey<OrderlywebUserGroupReportPermissionRecord, ReportRecord> FK_ORDERLYWEB_USER_GROUP_REPORT_PERMISSION_REPORT_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_REPORT_PERMISSION_REPORT_1;
    public static final ForeignKey<OrderlywebUserGroupUserRecord, OrderlywebUserRecord> FK_ORDERLYWEB_USER_GROUP_USER_ORDERLYWEB_USER_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_USER_ORDERLYWEB_USER_1;
    public static final ForeignKey<OrderlywebUserGroupUserRecord, OrderlywebUserGroupRecord> FK_ORDERLYWEB_USER_GROUP_USER_ORDERLYWEB_USER_GROUP_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_USER_ORDERLYWEB_USER_GROUP_1;
    public static final ForeignKey<OrderlywebUserGroupVersionPermissionRecord, OrderlywebUserGroupPermissionRecord> FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1;
    public static final ForeignKey<OrderlywebUserGroupVersionPermissionRecord, ReportVersionRecord> FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_REPORT_VERSION_1 = ForeignKeys0.FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_REPORT_VERSION_1;
    public static final ForeignKey<ParametersRecord, ReportVersionRecord> FK_PARAMETERS_REPORT_VERSION_1 = ForeignKeys0.FK_PARAMETERS_REPORT_VERSION_1;
    public static final ForeignKey<ParametersRecord, ParametersTypeRecord> FK_PARAMETERS_PARAMETERS_TYPE_1 = ForeignKeys0.FK_PARAMETERS_PARAMETERS_TYPE_1;
    public static final ForeignKey<ReportRecord, ReportVersionRecord> FK_REPORT_REPORT_VERSION_1 = ForeignKeys0.FK_REPORT_REPORT_VERSION_1;
    public static final ForeignKey<ReportVersionRecord, ReportRecord> FK_REPORT_VERSION_REPORT_1 = ForeignKeys0.FK_REPORT_VERSION_REPORT_1;
    public static final ForeignKey<ReportVersionArtefactRecord, ReportVersionRecord> FK_REPORT_VERSION_ARTEFACT_REPORT_VERSION_1 = ForeignKeys0.FK_REPORT_VERSION_ARTEFACT_REPORT_VERSION_1;
    public static final ForeignKey<ReportVersionArtefactRecord, ArtefactFormatRecord> FK_REPORT_VERSION_ARTEFACT_ARTEFACT_FORMAT_1 = ForeignKeys0.FK_REPORT_VERSION_ARTEFACT_ARTEFACT_FORMAT_1;
    public static final ForeignKey<ReportVersionDataRecord, ReportVersionRecord> FK_REPORT_VERSION_DATA_REPORT_VERSION_1 = ForeignKeys0.FK_REPORT_VERSION_DATA_REPORT_VERSION_1;
    public static final ForeignKey<ReportVersionDataRecord, DataRecord> FK_REPORT_VERSION_DATA_DATA_1 = ForeignKeys0.FK_REPORT_VERSION_DATA_DATA_1;
    public static final ForeignKey<ReportVersionPackageRecord, ReportVersionRecord> FK_REPORT_VERSION_PACKAGE_REPORT_VERSION_1 = ForeignKeys0.FK_REPORT_VERSION_PACKAGE_REPORT_VERSION_1;
    public static final ForeignKey<ReportVersionViewRecord, ReportVersionRecord> FK_REPORT_VERSION_VIEW_REPORT_VERSION_1 = ForeignKeys0.FK_REPORT_VERSION_VIEW_REPORT_VERSION_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<ArtefactFormatRecord> PK_ARTEFACT_FORMAT = createUniqueKey(ArtefactFormat.ARTEFACT_FORMAT, "pk_artefact_format", ArtefactFormat.ARTEFACT_FORMAT.NAME);
        public static final UniqueKey<ChangelogRecord> PK_CHANGELOG = createUniqueKey(Changelog.CHANGELOG, "pk_changelog", Changelog.CHANGELOG.ID);
        public static final UniqueKey<ChangelogLabelRecord> PK_CHANGELOG_LABEL = createUniqueKey(ChangelogLabel.CHANGELOG_LABEL, "pk_changelog_label", ChangelogLabel.CHANGELOG_LABEL.ID);
        public static final UniqueKey<DataRecord> PK_DATA = createUniqueKey(Data.DATA, "pk_data", Data.DATA.HASH);
        public static final UniqueKey<DependsRecord> PK_DEPENDS = createUniqueKey(Depends.DEPENDS, "pk_depends", Depends.DEPENDS.ID);
        public static final UniqueKey<FileRecord> PK_FILE = createUniqueKey(File.FILE, "pk_file", File.FILE.HASH);
        public static final UniqueKey<FileArtefactRecord> PK_FILE_ARTEFACT = createUniqueKey(FileArtefact.FILE_ARTEFACT, "pk_file_artefact", FileArtefact.FILE_ARTEFACT.ID);
        public static final UniqueKey<FileInputRecord> PK_FILE_INPUT = createUniqueKey(FileInput.FILE_INPUT, "pk_file_input", FileInput.FILE_INPUT.ID);
        public static final UniqueKey<FilePurposeRecord> PK_FILE_PURPOSE = createUniqueKey(FilePurpose.FILE_PURPOSE, "pk_file_purpose", FilePurpose.FILE_PURPOSE.NAME);
        public static final UniqueKey<OrderlyRecord> PK_ORDERLY = createUniqueKey(Orderly.ORDERLY, "pk_orderly", Orderly.ORDERLY.ID);
        public static final UniqueKey<OrderlySchemaRecord> PK_ORDERLY_SCHEMA = createUniqueKey(OrderlySchema.ORDERLY_SCHEMA, "pk_orderly_schema", OrderlySchema.ORDERLY_SCHEMA.SCHEMA_VERSION);
        public static final UniqueKey<OrderlySchemaTablesRecord> PK_ORDERLY_SCHEMA_TABLES = createUniqueKey(OrderlySchemaTables.ORDERLY_SCHEMA_TABLES, "pk_orderly_schema_tables", OrderlySchemaTables.ORDERLY_SCHEMA_TABLES.NAME);
        public static final UniqueKey<OrderlywebPermissionRecord> PK_ORDERLYWEB_PERMISSION = createUniqueKey(OrderlywebPermission.ORDERLYWEB_PERMISSION, "pk_orderlyweb_permission", OrderlywebPermission.ORDERLYWEB_PERMISSION.ID);
        public static final UniqueKey<OrderlywebUserRecord> PK_ORDERLYWEB_USER = createUniqueKey(OrderlywebUser.ORDERLYWEB_USER, "pk_orderlyweb_user", OrderlywebUser.ORDERLYWEB_USER.USERNAME);
        public static final UniqueKey<OrderlywebUserGroupRecord> PK_ORDERLYWEB_USER_GROUP = createUniqueKey(OrderlywebUserGroup.ORDERLYWEB_USER_GROUP, "pk_orderlyweb_user_group", OrderlywebUserGroup.ORDERLYWEB_USER_GROUP.ID);
        public static final UniqueKey<OrderlywebUserGroupPermissionRecord> PK_ORDERLYWEB_USER_GROUP_PERMISSION = createUniqueKey(OrderlywebUserGroupPermission.ORDERLYWEB_USER_GROUP_PERMISSION, "pk_orderlyweb_user_group_permission", OrderlywebUserGroupPermission.ORDERLYWEB_USER_GROUP_PERMISSION.ID);
        public static final UniqueKey<ParametersRecord> PK_PARAMETERS = createUniqueKey(Parameters.PARAMETERS, "pk_parameters", Parameters.PARAMETERS.ID);
        public static final UniqueKey<ParametersTypeRecord> PK_PARAMETERS_TYPE = createUniqueKey(ParametersType.PARAMETERS_TYPE, "pk_parameters_type", ParametersType.PARAMETERS_TYPE.NAME);
        public static final UniqueKey<ReportRecord> PK_REPORT = createUniqueKey(Report.REPORT, "pk_report", Report.REPORT.NAME);
        public static final UniqueKey<ReportVersionRecord> PK_REPORT_VERSION = createUniqueKey(ReportVersion.REPORT_VERSION, "pk_report_version", ReportVersion.REPORT_VERSION.ID);
        public static final UniqueKey<ReportVersionArtefactRecord> PK_REPORT_VERSION_ARTEFACT = createUniqueKey(ReportVersionArtefact.REPORT_VERSION_ARTEFACT, "pk_report_version_artefact", ReportVersionArtefact.REPORT_VERSION_ARTEFACT.ID);
        public static final UniqueKey<ReportVersionDataRecord> PK_REPORT_VERSION_DATA = createUniqueKey(ReportVersionData.REPORT_VERSION_DATA, "pk_report_version_data", ReportVersionData.REPORT_VERSION_DATA.ID);
        public static final UniqueKey<ReportVersionPackageRecord> PK_REPORT_VERSION_PACKAGE = createUniqueKey(ReportVersionPackage.REPORT_VERSION_PACKAGE, "pk_report_version_package", ReportVersionPackage.REPORT_VERSION_PACKAGE.ID);
        public static final UniqueKey<ReportVersionViewRecord> PK_REPORT_VERSION_VIEW = createUniqueKey(ReportVersionView.REPORT_VERSION_VIEW, "pk_report_version_view", ReportVersionView.REPORT_VERSION_VIEW.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<ChangelogRecord, ReportVersionRecord> FK_CHANGELOG_REPORT_VERSION_2 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, Changelog.CHANGELOG, "fk_changelog_report_version_2", Changelog.CHANGELOG.REPORT_VERSION);
        public static final ForeignKey<ChangelogRecord, ReportVersionRecord> FK_CHANGELOG_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, Changelog.CHANGELOG, "fk_changelog_report_version_1", Changelog.CHANGELOG.REPORT_VERSION_PUBLIC);
        public static final ForeignKey<ChangelogRecord, ChangelogLabelRecord> FK_CHANGELOG_CHANGELOG_LABEL_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_CHANGELOG_LABEL, Changelog.CHANGELOG, "fk_changelog_changelog_label_1", Changelog.CHANGELOG.LABEL);
        public static final ForeignKey<DependsRecord, ReportVersionRecord> FK_DEPENDS_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, Depends.DEPENDS, "fk_depends_report_version_1", Depends.DEPENDS.REPORT_VERSION);
        public static final ForeignKey<DependsRecord, FileArtefactRecord> FK_DEPENDS_FILE_ARTEFACT_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_FILE_ARTEFACT, Depends.DEPENDS, "fk_depends_file_artefact_1", Depends.DEPENDS.USE);
        public static final ForeignKey<FileArtefactRecord, ReportVersionArtefactRecord> FK_FILE_ARTEFACT_REPORT_VERSION_ARTEFACT_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION_ARTEFACT, FileArtefact.FILE_ARTEFACT, "fk_file_artefact_report_version_artefact_1", FileArtefact.FILE_ARTEFACT.ARTEFACT);
        public static final ForeignKey<FileArtefactRecord, FileRecord> FK_FILE_ARTEFACT_FILE_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_FILE, FileArtefact.FILE_ARTEFACT, "fk_file_artefact_file_1", FileArtefact.FILE_ARTEFACT.FILE_HASH);
        public static final ForeignKey<FileInputRecord, ReportVersionRecord> FK_FILE_INPUT_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, FileInput.FILE_INPUT, "fk_file_input_report_version_1", FileInput.FILE_INPUT.REPORT_VERSION);
        public static final ForeignKey<FileInputRecord, FileRecord> FK_FILE_INPUT_FILE_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_FILE, FileInput.FILE_INPUT, "fk_file_input_file_1", FileInput.FILE_INPUT.FILE_HASH);
        public static final ForeignKey<FileInputRecord, FilePurposeRecord> FK_FILE_INPUT_FILE_PURPOSE_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_FILE_PURPOSE, FileInput.FILE_INPUT, "fk_file_input_file_purpose_1", FileInput.FILE_INPUT.FILE_PURPOSE);
        public static final ForeignKey<OrderlywebUserGroupGlobalPermissionRecord, OrderlywebUserGroupPermissionRecord> FK_ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ORDERLYWEB_USER_GROUP_PERMISSION, OrderlywebUserGroupGlobalPermission.ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION, "fk_orderlyweb_user_group_global_permission_orderlyweb_user_group_permission_1", OrderlywebUserGroupGlobalPermission.ORDERLYWEB_USER_GROUP_GLOBAL_PERMISSION.ID);
        public static final ForeignKey<OrderlywebUserGroupPermissionRecord, OrderlywebUserGroupRecord> FK_ORDERLYWEB_USER_GROUP_PERMISSION_ORDERLYWEB_USER_GROUP_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ORDERLYWEB_USER_GROUP, OrderlywebUserGroupPermission.ORDERLYWEB_USER_GROUP_PERMISSION, "fk_orderlyweb_user_group_permission_orderlyweb_user_group_1", OrderlywebUserGroupPermission.ORDERLYWEB_USER_GROUP_PERMISSION.USER_GROUP);
        public static final ForeignKey<OrderlywebUserGroupPermissionRecord, OrderlywebPermissionRecord> FK_ORDERLYWEB_USER_GROUP_PERMISSION_ORDERLYWEB_PERMISSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ORDERLYWEB_PERMISSION, OrderlywebUserGroupPermission.ORDERLYWEB_USER_GROUP_PERMISSION, "fk_orderlyweb_user_group_permission_orderlyweb_permission_1", OrderlywebUserGroupPermission.ORDERLYWEB_USER_GROUP_PERMISSION.PERMISSION);
        public static final ForeignKey<OrderlywebUserGroupReportPermissionRecord, OrderlywebUserGroupPermissionRecord> FK_ORDERLYWEB_USER_GROUP_REPORT_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ORDERLYWEB_USER_GROUP_PERMISSION, OrderlywebUserGroupReportPermission.ORDERLYWEB_USER_GROUP_REPORT_PERMISSION, "fk_orderlyweb_user_group_report_permission_orderlyweb_user_group_permission_1", OrderlywebUserGroupReportPermission.ORDERLYWEB_USER_GROUP_REPORT_PERMISSION.ID);
        public static final ForeignKey<OrderlywebUserGroupReportPermissionRecord, ReportRecord> FK_ORDERLYWEB_USER_GROUP_REPORT_PERMISSION_REPORT_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT, OrderlywebUserGroupReportPermission.ORDERLYWEB_USER_GROUP_REPORT_PERMISSION, "fk_orderlyweb_user_group_report_permission_report_1", OrderlywebUserGroupReportPermission.ORDERLYWEB_USER_GROUP_REPORT_PERMISSION.REPORT);
        public static final ForeignKey<OrderlywebUserGroupUserRecord, OrderlywebUserRecord> FK_ORDERLYWEB_USER_GROUP_USER_ORDERLYWEB_USER_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ORDERLYWEB_USER, OrderlywebUserGroupUser.ORDERLYWEB_USER_GROUP_USER, "fk_orderlyweb_user_group_user_orderlyweb_user_1", OrderlywebUserGroupUser.ORDERLYWEB_USER_GROUP_USER.USER);
        public static final ForeignKey<OrderlywebUserGroupUserRecord, OrderlywebUserGroupRecord> FK_ORDERLYWEB_USER_GROUP_USER_ORDERLYWEB_USER_GROUP_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ORDERLYWEB_USER_GROUP, OrderlywebUserGroupUser.ORDERLYWEB_USER_GROUP_USER, "fk_orderlyweb_user_group_user_orderlyweb_user_group_1", OrderlywebUserGroupUser.ORDERLYWEB_USER_GROUP_USER.USER_GROUP);
        public static final ForeignKey<OrderlywebUserGroupVersionPermissionRecord, OrderlywebUserGroupPermissionRecord> FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ORDERLYWEB_USER_GROUP_PERMISSION, OrderlywebUserGroupVersionPermission.ORDERLYWEB_USER_GROUP_VERSION_PERMISSION, "fk_orderlyweb_user_group_version_permission_orderlyweb_user_group_permission_1", OrderlywebUserGroupVersionPermission.ORDERLYWEB_USER_GROUP_VERSION_PERMISSION.ID);
        public static final ForeignKey<OrderlywebUserGroupVersionPermissionRecord, ReportVersionRecord> FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, OrderlywebUserGroupVersionPermission.ORDERLYWEB_USER_GROUP_VERSION_PERMISSION, "fk_orderlyweb_user_group_version_permission_report_version_1", OrderlywebUserGroupVersionPermission.ORDERLYWEB_USER_GROUP_VERSION_PERMISSION.VERSION);
        public static final ForeignKey<ParametersRecord, ReportVersionRecord> FK_PARAMETERS_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, Parameters.PARAMETERS, "fk_parameters_report_version_1", Parameters.PARAMETERS.REPORT_VERSION);
        public static final ForeignKey<ParametersRecord, ParametersTypeRecord> FK_PARAMETERS_PARAMETERS_TYPE_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_PARAMETERS_TYPE, Parameters.PARAMETERS, "fk_parameters_parameters_type_1", Parameters.PARAMETERS.TYPE);
        public static final ForeignKey<ReportRecord, ReportVersionRecord> FK_REPORT_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, Report.REPORT, "fk_report_report_version_1", Report.REPORT.LATEST);
        public static final ForeignKey<ReportVersionRecord, ReportRecord> FK_REPORT_VERSION_REPORT_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT, ReportVersion.REPORT_VERSION, "fk_report_version_report_1", ReportVersion.REPORT_VERSION.REPORT);
        public static final ForeignKey<ReportVersionArtefactRecord, ReportVersionRecord> FK_REPORT_VERSION_ARTEFACT_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, ReportVersionArtefact.REPORT_VERSION_ARTEFACT, "fk_report_version_artefact_report_version_1", ReportVersionArtefact.REPORT_VERSION_ARTEFACT.REPORT_VERSION);
        public static final ForeignKey<ReportVersionArtefactRecord, ArtefactFormatRecord> FK_REPORT_VERSION_ARTEFACT_ARTEFACT_FORMAT_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_ARTEFACT_FORMAT, ReportVersionArtefact.REPORT_VERSION_ARTEFACT, "fk_report_version_artefact_artefact_format_1", ReportVersionArtefact.REPORT_VERSION_ARTEFACT.FORMAT);
        public static final ForeignKey<ReportVersionDataRecord, ReportVersionRecord> FK_REPORT_VERSION_DATA_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, ReportVersionData.REPORT_VERSION_DATA, "fk_report_version_data_report_version_1", ReportVersionData.REPORT_VERSION_DATA.REPORT_VERSION);
        public static final ForeignKey<ReportVersionDataRecord, DataRecord> FK_REPORT_VERSION_DATA_DATA_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_DATA, ReportVersionData.REPORT_VERSION_DATA, "fk_report_version_data_data_1", ReportVersionData.REPORT_VERSION_DATA.HASH);
        public static final ForeignKey<ReportVersionPackageRecord, ReportVersionRecord> FK_REPORT_VERSION_PACKAGE_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, ReportVersionPackage.REPORT_VERSION_PACKAGE, "fk_report_version_package_report_version_1", ReportVersionPackage.REPORT_VERSION_PACKAGE.REPORT_VERSION);
        public static final ForeignKey<ReportVersionViewRecord, ReportVersionRecord> FK_REPORT_VERSION_VIEW_REPORT_VERSION_1 = createForeignKey(org.vaccineimpact.orderlyweb.db.Keys.PK_REPORT_VERSION, ReportVersionView.REPORT_VERSION_VIEW, "fk_report_version_view_report_version_1", ReportVersionView.REPORT_VERSION_VIEW.REPORT_VERSION);
    }
}
