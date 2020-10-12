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
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.Keys;
import org.vaccineimpact.orderlyweb.db.tables.records.FileRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class File extends TableImpl<FileRecord> {

    private static final long serialVersionUID = 1829449622;

    /**
     * The reference instance of <code>file</code>
     */
    public static final File FILE = new File();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FileRecord> getRecordType() {
        return FileRecord.class;
    }

    /**
     * The column <code>file.hash</code>.
     */
    public final TableField<FileRecord, String> HASH = createField(DSL.name("hash"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>file.size</code>.
     */
    public final TableField<FileRecord, Long> SIZE = createField(DSL.name("size"), org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>file</code> table reference
     */
    public File() {
        this(DSL.name("file"), null);
    }

    /**
     * Create an aliased <code>file</code> table reference
     */
    public File(String alias) {
        this(DSL.name(alias), FILE);
    }

    /**
     * Create an aliased <code>file</code> table reference
     */
    public File(Name alias) {
        this(alias, FILE);
    }

    private File(Name alias, Table<FileRecord> aliased) {
        this(alias, aliased, null);
    }

    private File(Name alias, Table<FileRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> File(Table<O> child, ForeignKey<O, FileRecord> key) {
        super(child, key, FILE);
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<FileRecord> getPrimaryKey() {
        return Keys.PK_FILE;
    }

    @Override
    public List<UniqueKey<FileRecord>> getKeys() {
        return Arrays.<UniqueKey<FileRecord>>asList(Keys.PK_FILE);
    }

    @Override
    public File as(String alias) {
        return new File(DSL.name(alias), this);
    }

    @Override
    public File as(Name alias) {
        return new File(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public File rename(String name) {
        return new File(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public File rename(Name name) {
        return new File(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, Long> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
