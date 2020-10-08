/*
 * This file is generated by jOOQ.
 */
package org.vaccineimpact.orderlyweb.db.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row14;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.Keys;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReportVersion extends TableImpl<ReportVersionRecord> {

    private static final long serialVersionUID = -462684146;

    /**
     * The reference instance of <code>report_version</code>
     */
    public static final ReportVersion REPORT_VERSION = new ReportVersion();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReportVersionRecord> getRecordType() {
        return ReportVersionRecord.class;
    }

    /**
     * The column <code>report_version.id</code>.
     */
    public final TableField<ReportVersionRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>report_version.report</code>.
     */
    public final TableField<ReportVersionRecord, String> REPORT = createField(DSL.name("report"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>report_version.date</code>.
     */
    public final TableField<ReportVersionRecord, Timestamp> DATE = createField(DSL.name("date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>report_version.displayname</code>.
     */
    public final TableField<ReportVersionRecord, String> DISPLAYNAME = createField(DSL.name("displayname"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>report_version.description</code>.
     */
    public final TableField<ReportVersionRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>report_version.connection</code>.
     */
    public final TableField<ReportVersionRecord, Boolean> CONNECTION = createField(DSL.name("connection"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>report_version.published</code>.
     */
    public final TableField<ReportVersionRecord, Boolean> PUBLISHED = createField(DSL.name("published"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>report_version.elapsed</code>.
     */
    public final TableField<ReportVersionRecord, Double> ELAPSED = createField(DSL.name("elapsed"), org.jooq.impl.SQLDataType.DOUBLE.nullable(false), this, "");

    /**
     * The column <code>report_version.git_sha</code>.
     */
    public final TableField<ReportVersionRecord, String> GIT_SHA = createField(DSL.name("git_sha"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>report_version.git_branch</code>.
     */
    public final TableField<ReportVersionRecord, String> GIT_BRANCH = createField(DSL.name("git_branch"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>report_version.git_clean</code>.
     */
    public final TableField<ReportVersionRecord, Boolean> GIT_CLEAN = createField(DSL.name("git_clean"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>report_version.requester</code>.
     */
    public final TableField<ReportVersionRecord, String> REQUESTER = createField(DSL.name("requester"), org.jooq.impl.SQLDataType.CHAR.nullable(false), this, "");

    /**
     * The column <code>report_version.author</code>.
     */
    public final TableField<ReportVersionRecord, String> AUTHOR = createField(DSL.name("author"), org.jooq.impl.SQLDataType.CHAR.nullable(false), this, "");

    /**
     * The column <code>report_version.comment</code>.
     */
    public final TableField<ReportVersionRecord, String> COMMENT = createField(DSL.name("comment"), org.jooq.impl.SQLDataType.CHAR, this, "");

    /**
     * Create a <code>report_version</code> table reference
     */
    public ReportVersion() {
        this(DSL.name("report_version"), null);
    }

    /**
     * Create an aliased <code>report_version</code> table reference
     */
    public ReportVersion(String alias) {
        this(DSL.name(alias), REPORT_VERSION);
    }

    /**
     * Create an aliased <code>report_version</code> table reference
     */
    public ReportVersion(Name alias) {
        this(alias, REPORT_VERSION);
    }

    private ReportVersion(Name alias, Table<ReportVersionRecord> aliased) {
        this(alias, aliased, null);
    }

    private ReportVersion(Name alias, Table<ReportVersionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> ReportVersion(Table<O> child, ForeignKey<O, ReportVersionRecord> key) {
        super(child, key, REPORT_VERSION);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<ReportVersionRecord> getPrimaryKey() {
        return Keys.PK_REPORT_VERSION;
    }

    @Override
    public List<UniqueKey<ReportVersionRecord>> getKeys() {
        return Arrays.<UniqueKey<ReportVersionRecord>>asList(Keys.PK_REPORT_VERSION);
    }

    @Override
    public List<ForeignKey<ReportVersionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ReportVersionRecord, ?>>asList(Keys.FK_REPORT_VERSION_REPORT_1);
    }

    public Report report() {
        return new Report(this, Keys.FK_REPORT_VERSION_REPORT_1);
    }

    @Override
    public ReportVersion as(String alias) {
        return new ReportVersion(DSL.name(alias), this);
    }

    @Override
    public ReportVersion as(Name alias) {
        return new ReportVersion(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ReportVersion rename(String name) {
        return new ReportVersion(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ReportVersion rename(Name name) {
        return new ReportVersion(name, null);
    }

    // -------------------------------------------------------------------------
    // Row14 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row14<String, String, Timestamp, String, String, Boolean, Boolean, Double, String, String, Boolean, String, String, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }
}
