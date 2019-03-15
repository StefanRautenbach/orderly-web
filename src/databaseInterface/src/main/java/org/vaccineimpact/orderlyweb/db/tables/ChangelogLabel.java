/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.Keys;
import org.vaccineimpact.orderlyweb.db.tables.records.ChangelogLabelRecord;


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
public class ChangelogLabel extends TableImpl<ChangelogLabelRecord> {

    private static final long serialVersionUID = -1683558095;

    /**
     * The reference instance of <code>changelog_label</code>
     */
    public static final ChangelogLabel CHANGELOG_LABEL = new ChangelogLabel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ChangelogLabelRecord> getRecordType() {
        return ChangelogLabelRecord.class;
    }

    /**
     * The column <code>changelog_label.id</code>.
     */
    public final TableField<ChangelogLabelRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>changelog_label.public</code>.
     */
    public final TableField<ChangelogLabelRecord, Boolean> PUBLIC = createField("public", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * Create a <code>changelog_label</code> table reference
     */
    public ChangelogLabel() {
        this("changelog_label", null);
    }

    /**
     * Create an aliased <code>changelog_label</code> table reference
     */
    public ChangelogLabel(String alias) {
        this(alias, CHANGELOG_LABEL);
    }

    private ChangelogLabel(String alias, Table<ChangelogLabelRecord> aliased) {
        this(alias, aliased, null);
    }

    private ChangelogLabel(String alias, Table<ChangelogLabelRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ChangelogLabelRecord> getPrimaryKey() {
        return Keys.PK_CHANGELOG_LABEL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ChangelogLabelRecord>> getKeys() {
        return Arrays.<UniqueKey<ChangelogLabelRecord>>asList(Keys.PK_CHANGELOG_LABEL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChangelogLabel as(String alias) {
        return new ChangelogLabel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ChangelogLabel rename(String name) {
        return new ChangelogLabel(name, null);
    }
}
