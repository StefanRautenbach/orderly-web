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
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.Keys;
import org.vaccineimpact.orderlyweb.db.tables.records.ReportVersionInstanceRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ReportVersionInstance extends TableImpl<ReportVersionInstanceRecord> {

    private static final long serialVersionUID = -2054588;

    /**
     * The reference instance of <code>report_version_instance</code>
     */
    public static final ReportVersionInstance REPORT_VERSION_INSTANCE = new ReportVersionInstance();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ReportVersionInstanceRecord> getRecordType() {
        return ReportVersionInstanceRecord.class;
    }

    /**
     * The column <code>report_version_instance.report_version</code>.
     */
    public final TableField<ReportVersionInstanceRecord, String> REPORT_VERSION = createField(DSL.name("report_version"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>report_version_instance.type</code>.
     */
    public final TableField<ReportVersionInstanceRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>report_version_instance.instance</code>.
     */
    public final TableField<ReportVersionInstanceRecord, String> INSTANCE = createField(DSL.name("instance"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>report_version_instance</code> table reference
     */
    public ReportVersionInstance() {
        this(DSL.name("report_version_instance"), null);
    }

    /**
     * Create an aliased <code>report_version_instance</code> table reference
     */
    public ReportVersionInstance(String alias) {
        this(DSL.name(alias), REPORT_VERSION_INSTANCE);
    }

    /**
     * Create an aliased <code>report_version_instance</code> table reference
     */
    public ReportVersionInstance(Name alias) {
        this(alias, REPORT_VERSION_INSTANCE);
    }

    private ReportVersionInstance(Name alias, Table<ReportVersionInstanceRecord> aliased) {
        this(alias, aliased, null);
    }

    private ReportVersionInstance(Name alias, Table<ReportVersionInstanceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> ReportVersionInstance(Table<O> child, ForeignKey<O, ReportVersionInstanceRecord> key) {
        super(child, key, REPORT_VERSION_INSTANCE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<ReportVersionInstanceRecord> getPrimaryKey() {
        return Keys.PK_REPORT_VERSION_INSTANCE;
    }

    @Override
    public List<UniqueKey<ReportVersionInstanceRecord>> getKeys() {
        return Arrays.<UniqueKey<ReportVersionInstanceRecord>>asList(Keys.PK_REPORT_VERSION_INSTANCE);
    }

    @Override
    public List<ForeignKey<ReportVersionInstanceRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ReportVersionInstanceRecord, ?>>asList(Keys.FK_REPORT_VERSION_INSTANCE_REPORT_VERSION_1);
    }

    public ReportVersion reportVersion() {
        return new ReportVersion(this, Keys.FK_REPORT_VERSION_INSTANCE_REPORT_VERSION_1);
    }

    @Override
    public ReportVersionInstance as(String alias) {
        return new ReportVersionInstance(DSL.name(alias), this);
    }

    @Override
    public ReportVersionInstance as(Name alias) {
        return new ReportVersionInstance(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ReportVersionInstance rename(String name) {
        return new ReportVersionInstance(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ReportVersionInstance rename(Name name) {
        return new ReportVersionInstance(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}