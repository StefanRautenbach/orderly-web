/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.reporting_api.db;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import org.vaccineimpact.reporting_api.db.tables.ArtefactFormat;
import org.vaccineimpact.reporting_api.db.tables.Changelog;
import org.vaccineimpact.reporting_api.db.tables.ChangelogLabel;
import org.vaccineimpact.reporting_api.db.tables.Data;
import org.vaccineimpact.reporting_api.db.tables.Depends;
import org.vaccineimpact.reporting_api.db.tables.File;
import org.vaccineimpact.reporting_api.db.tables.FileArtefact;
import org.vaccineimpact.reporting_api.db.tables.FileInput;
import org.vaccineimpact.reporting_api.db.tables.FilePurpose;
import org.vaccineimpact.reporting_api.db.tables.Orderly;
import org.vaccineimpact.reporting_api.db.tables.OrderlySchema;
import org.vaccineimpact.reporting_api.db.tables.OrderlySchemaTables;
import org.vaccineimpact.reporting_api.db.tables.Parameters;
import org.vaccineimpact.reporting_api.db.tables.ParametersType;
import org.vaccineimpact.reporting_api.db.tables.Report;
import org.vaccineimpact.reporting_api.db.tables.ReportVersion;
import org.vaccineimpact.reporting_api.db.tables.ReportVersionArtefact;
import org.vaccineimpact.reporting_api.db.tables.ReportVersionData;
import org.vaccineimpact.reporting_api.db.tables.ReportVersionPackage;
import org.vaccineimpact.reporting_api.db.tables.ReportVersionView;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = -1130226641;

    /**
     * The reference instance of <code></code>
     */
    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    /**
     * The table <code>artefact_format</code>.
     */
    public final ArtefactFormat ARTEFACT_FORMAT = org.vaccineimpact.reporting_api.db.tables.ArtefactFormat.ARTEFACT_FORMAT;

    /**
     * The table <code>changelog</code>.
     */
    public final Changelog CHANGELOG = org.vaccineimpact.reporting_api.db.tables.Changelog.CHANGELOG;

    /**
     * The table <code>changelog_label</code>.
     */
    public final ChangelogLabel CHANGELOG_LABEL = org.vaccineimpact.reporting_api.db.tables.ChangelogLabel.CHANGELOG_LABEL;

    /**
     * The table <code>data</code>.
     */
    public final Data DATA = org.vaccineimpact.reporting_api.db.tables.Data.DATA;

    /**
     * The table <code>depends</code>.
     */
    public final Depends DEPENDS = org.vaccineimpact.reporting_api.db.tables.Depends.DEPENDS;

    /**
     * The table <code>file</code>.
     */
    public final File FILE = org.vaccineimpact.reporting_api.db.tables.File.FILE;

    /**
     * The table <code>file_artefact</code>.
     */
    public final FileArtefact FILE_ARTEFACT = org.vaccineimpact.reporting_api.db.tables.FileArtefact.FILE_ARTEFACT;

    /**
     * The table <code>file_input</code>.
     */
    public final FileInput FILE_INPUT = org.vaccineimpact.reporting_api.db.tables.FileInput.FILE_INPUT;

    /**
     * The table <code>file_purpose</code>.
     */
    public final FilePurpose FILE_PURPOSE = org.vaccineimpact.reporting_api.db.tables.FilePurpose.FILE_PURPOSE;

    /**
     * The table <code>orderly</code>.
     */
    public final Orderly ORDERLY = org.vaccineimpact.reporting_api.db.tables.Orderly.ORDERLY;

    /**
     * The table <code>orderly_schema</code>.
     */
    public final OrderlySchema ORDERLY_SCHEMA = org.vaccineimpact.reporting_api.db.tables.OrderlySchema.ORDERLY_SCHEMA;

    /**
     * The table <code>orderly_schema_tables</code>.
     */
    public final OrderlySchemaTables ORDERLY_SCHEMA_TABLES = org.vaccineimpact.reporting_api.db.tables.OrderlySchemaTables.ORDERLY_SCHEMA_TABLES;

    /**
     * The table <code>parameters</code>.
     */
    public final Parameters PARAMETERS = org.vaccineimpact.reporting_api.db.tables.Parameters.PARAMETERS;

    /**
     * The table <code>parameters_type</code>.
     */
    public final ParametersType PARAMETERS_TYPE = org.vaccineimpact.reporting_api.db.tables.ParametersType.PARAMETERS_TYPE;

    /**
     * The table <code>report</code>.
     */
    public final Report REPORT = org.vaccineimpact.reporting_api.db.tables.Report.REPORT;

    /**
     * The table <code>report_version</code>.
     */
    public final ReportVersion REPORT_VERSION = org.vaccineimpact.reporting_api.db.tables.ReportVersion.REPORT_VERSION;

    /**
     * The table <code>report_version_artefact</code>.
     */
    public final ReportVersionArtefact REPORT_VERSION_ARTEFACT = org.vaccineimpact.reporting_api.db.tables.ReportVersionArtefact.REPORT_VERSION_ARTEFACT;

    /**
     * The table <code>report_version_data</code>.
     */
    public final ReportVersionData REPORT_VERSION_DATA = org.vaccineimpact.reporting_api.db.tables.ReportVersionData.REPORT_VERSION_DATA;

    /**
     * The table <code>report_version_package</code>.
     */
    public final ReportVersionPackage REPORT_VERSION_PACKAGE = org.vaccineimpact.reporting_api.db.tables.ReportVersionPackage.REPORT_VERSION_PACKAGE;

    /**
     * The table <code>report_version_view</code>.
     */
    public final ReportVersionView REPORT_VERSION_VIEW = org.vaccineimpact.reporting_api.db.tables.ReportVersionView.REPORT_VERSION_VIEW;

    /**
     * No further instances allowed
     */
    private DefaultSchema() {
        super("", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            ArtefactFormat.ARTEFACT_FORMAT,
            Changelog.CHANGELOG,
            ChangelogLabel.CHANGELOG_LABEL,
            Data.DATA,
            Depends.DEPENDS,
            File.FILE,
            FileArtefact.FILE_ARTEFACT,
            FileInput.FILE_INPUT,
            FilePurpose.FILE_PURPOSE,
            Orderly.ORDERLY,
            OrderlySchema.ORDERLY_SCHEMA,
            OrderlySchemaTables.ORDERLY_SCHEMA_TABLES,
            Parameters.PARAMETERS,
            ParametersType.PARAMETERS_TYPE,
            Report.REPORT,
            ReportVersion.REPORT_VERSION,
            ReportVersionArtefact.REPORT_VERSION_ARTEFACT,
            ReportVersionData.REPORT_VERSION_DATA,
            ReportVersionPackage.REPORT_VERSION_PACKAGE,
            ReportVersionView.REPORT_VERSION_VIEW);
    }
}
