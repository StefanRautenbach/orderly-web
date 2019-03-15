/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.Keys;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionPackageRecord;


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
public class ReportVersionPackage extends TableImpl<ReportVersionPackageRecord> {

    private static final long serialVersionUID = 267679061;

    /**
     * The reference instance of <code>report_version_package</code>
     */
    public static final ReportVersionPackage REPORT_VERSION_PACKAGE = new ReportVersionPackage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReportVersionPackageRecord> getRecordType() {
        return ReportVersionPackageRecord.class;
    }

    /**
     * The column <code>report_version_package.id</code>.
     */
    public final TableField<ReportVersionPackageRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>report_version_package.report_version</code>.
     */
    public final TableField<ReportVersionPackageRecord, String> REPORT_VERSION = createField("report_version", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>report_version_package.package_name</code>.
     */
    public final TableField<ReportVersionPackageRecord, String> PACKAGE_NAME = createField("package_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>report_version_package.package_version</code>.
     */
    public final TableField<ReportVersionPackageRecord, String> PACKAGE_VERSION = createField("package_version", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>report_version_package</code> table reference
     */
    public ReportVersionPackage() {
        this("report_version_package", null);
    }

    /**
     * Create an aliased <code>report_version_package</code> table reference
     */
    public ReportVersionPackage(String alias) {
        this(alias, REPORT_VERSION_PACKAGE);
    }

    private ReportVersionPackage(String alias, Table<ReportVersionPackageRecord> aliased) {
        this(alias, aliased, null);
    }

    private ReportVersionPackage(String alias, Table<ReportVersionPackageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ReportVersionPackageRecord> getPrimaryKey() {
        return Keys.PK_REPORT_VERSION_PACKAGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ReportVersionPackageRecord>> getKeys() {
        return Arrays.<UniqueKey<ReportVersionPackageRecord>>asList(Keys.PK_REPORT_VERSION_PACKAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ReportVersionPackageRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ReportVersionPackageRecord, ?>>asList(Keys.FK_REPORT_VERSION_PACKAGE_REPORT_VERSION_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReportVersionPackage as(String alias) {
        return new ReportVersionPackage(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ReportVersionPackage rename(String name) {
        return new ReportVersionPackage(name, null);
    }
}