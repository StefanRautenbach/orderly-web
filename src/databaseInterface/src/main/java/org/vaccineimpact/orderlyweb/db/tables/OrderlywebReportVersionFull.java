/*
 * This file is generated by jOOQ.
 */
package org.vaccineimpact.orderlyweb.db.tables;


import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row11;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebReportVersionFullRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderlywebReportVersionFull extends TableImpl<OrderlywebReportVersionFullRecord> {

    private static final long serialVersionUID = -269891163;

    /**
     * The reference instance of <code>orderlyweb_report_version_full</code>
     */
    public static final OrderlywebReportVersionFull ORDERLYWEB_REPORT_VERSION_FULL = new OrderlywebReportVersionFull();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderlywebReportVersionFullRecord> getRecordType() {
        return OrderlywebReportVersionFullRecord.class;
    }

    /**
     * The column <code>orderlyweb_report_version_full.id</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, String> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.report</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, String> REPORT = createField(DSL.name("report"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.date</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, Timestamp> DATE = createField(DSL.name("date"), org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.displayname</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, String> DISPLAYNAME = createField(DSL.name("displayname"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.description</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.connection</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, Boolean> CONNECTION = createField(DSL.name("connection"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.elapsed</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, Double> ELAPSED = createField(DSL.name("elapsed"), org.jooq.impl.SQLDataType.DOUBLE, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.git_sha</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, String> GIT_SHA = createField(DSL.name("git_sha"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.git_branch</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, String> GIT_BRANCH = createField(DSL.name("git_branch"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.git_clean</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, Boolean> GIT_CLEAN = createField(DSL.name("git_clean"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>orderlyweb_report_version_full.published</code>.
     */
    public final TableField<OrderlywebReportVersionFullRecord, Boolean> PUBLISHED = createField(DSL.name("published"), org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * Create a <code>orderlyweb_report_version_full</code> table reference
     */
    public OrderlywebReportVersionFull() {
        this(DSL.name("orderlyweb_report_version_full"), null);
    }

    /**
     * Create an aliased <code>orderlyweb_report_version_full</code> table reference
     */
    public OrderlywebReportVersionFull(String alias) {
        this(DSL.name(alias), ORDERLYWEB_REPORT_VERSION_FULL);
    }

    /**
     * Create an aliased <code>orderlyweb_report_version_full</code> table reference
     */
    public OrderlywebReportVersionFull(Name alias) {
        this(alias, ORDERLYWEB_REPORT_VERSION_FULL);
    }

    private OrderlywebReportVersionFull(Name alias, Table<OrderlywebReportVersionFullRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderlywebReportVersionFull(Name alias, Table<OrderlywebReportVersionFullRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.view("CREATE VIEW orderlyweb_report_version_full AS\nSELECT rv.id, report, date, displayname, description, connection, elapsed, git_sha, git_branch, git_clean, ow_rv.published\nFROM report_version rv\nINNER JOIN orderlyweb_report_version ow_rv\nON rv.id = ow_rv.id"));
    }

    public <O extends Record> OrderlywebReportVersionFull(Table<O> child, ForeignKey<O, OrderlywebReportVersionFullRecord> key) {
        super(child, key, ORDERLYWEB_REPORT_VERSION_FULL);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public OrderlywebReportVersionFull as(String alias) {
        return new OrderlywebReportVersionFull(DSL.name(alias), this);
    }

    @Override
    public OrderlywebReportVersionFull as(Name alias) {
        return new OrderlywebReportVersionFull(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderlywebReportVersionFull rename(String name) {
        return new OrderlywebReportVersionFull(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderlywebReportVersionFull rename(Name name) {
        return new OrderlywebReportVersionFull(name, null);
    }

    // -------------------------------------------------------------------------
    // Row11 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row11<String, String, Timestamp, String, String, Boolean, Double, String, String, Boolean, Boolean> fieldsRow() {
        return (Row11) super.fieldsRow();
    }
}
