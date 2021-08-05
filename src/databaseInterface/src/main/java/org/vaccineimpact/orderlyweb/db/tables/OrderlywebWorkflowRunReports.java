/*
 * This file is generated by jOOQ.
 */
package org.vaccineimpact.orderlyweb.db.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.Keys;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebWorkflowRunReportsRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OrderlywebWorkflowRunReports extends TableImpl<OrderlywebWorkflowRunReportsRecord> {

    private static final long serialVersionUID = -1369221971;

    /**
     * The reference instance of <code>orderlyweb_workflow_run_reports</code>
     */
    public static final OrderlywebWorkflowRunReports ORDERLYWEB_WORKFLOW_RUN_REPORTS = new OrderlywebWorkflowRunReports();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderlywebWorkflowRunReportsRecord> getRecordType() {
        return OrderlywebWorkflowRunReportsRecord.class;
    }

    /**
     * The column <code>orderlyweb_workflow_run_reports.id</code>.
     */
    public final TableField<OrderlywebWorkflowRunReportsRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>orderlyweb_workflow_run_reports.workflow_key</code>.
     */
    public final TableField<OrderlywebWorkflowRunReportsRecord, String> WORKFLOW_KEY = createField(DSL.name("workflow_key"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>orderlyweb_workflow_run_reports.key</code>.
     */
    public final TableField<OrderlywebWorkflowRunReportsRecord, String> KEY = createField(DSL.name("key"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>orderlyweb_workflow_run_reports.report</code>.
     */
    public final TableField<OrderlywebWorkflowRunReportsRecord, String> REPORT = createField(DSL.name("report"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>orderlyweb_workflow_run_reports.params</code>.
     */
    public final TableField<OrderlywebWorkflowRunReportsRecord, String> PARAMS = createField(DSL.name("params"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>orderlyweb_workflow_run_reports</code> table reference
     */
    public OrderlywebWorkflowRunReports() {
        this(DSL.name("orderlyweb_workflow_run_reports"), null);
    }

    /**
     * Create an aliased <code>orderlyweb_workflow_run_reports</code> table reference
     */
    public OrderlywebWorkflowRunReports(String alias) {
        this(DSL.name(alias), ORDERLYWEB_WORKFLOW_RUN_REPORTS);
    }

    /**
     * Create an aliased <code>orderlyweb_workflow_run_reports</code> table reference
     */
    public OrderlywebWorkflowRunReports(Name alias) {
        this(alias, ORDERLYWEB_WORKFLOW_RUN_REPORTS);
    }

    private OrderlywebWorkflowRunReports(Name alias, Table<OrderlywebWorkflowRunReportsRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderlywebWorkflowRunReports(Name alias, Table<OrderlywebWorkflowRunReportsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> OrderlywebWorkflowRunReports(Table<O> child, ForeignKey<O, OrderlywebWorkflowRunReportsRecord> key) {
        super(child, key, ORDERLYWEB_WORKFLOW_RUN_REPORTS);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<OrderlywebWorkflowRunReportsRecord> getPrimaryKey() {
        return Keys.PK_ORDERLYWEB_WORKFLOW_RUN_REPORTS;
    }

    @Override
    public List<UniqueKey<OrderlywebWorkflowRunReportsRecord>> getKeys() {
        return Arrays.<UniqueKey<OrderlywebWorkflowRunReportsRecord>>asList(Keys.PK_ORDERLYWEB_WORKFLOW_RUN_REPORTS, Keys.SQLITE_AUTOINDEX_ORDERLYWEB_WORKFLOW_RUN_REPORTS_1);
    }

    @Override
    public List<ForeignKey<OrderlywebWorkflowRunReportsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<OrderlywebWorkflowRunReportsRecord, ?>>asList(Keys.FK_ORDERLYWEB_WORKFLOW_RUN_REPORTS_ORDERLYWEB_WORKFLOW_RUN_1);
    }

    public OrderlywebWorkflowRun orderlywebWorkflowRun() {
        return new OrderlywebWorkflowRun(this, Keys.FK_ORDERLYWEB_WORKFLOW_RUN_REPORTS_ORDERLYWEB_WORKFLOW_RUN_1);
    }

    @Override
    public OrderlywebWorkflowRunReports as(String alias) {
        return new OrderlywebWorkflowRunReports(DSL.name(alias), this);
    }

    @Override
    public OrderlywebWorkflowRunReports as(Name alias) {
        return new OrderlywebWorkflowRunReports(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderlywebWorkflowRunReports rename(String name) {
        return new OrderlywebWorkflowRunReports(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderlywebWorkflowRunReports rename(Name name) {
        return new OrderlywebWorkflowRunReports(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
