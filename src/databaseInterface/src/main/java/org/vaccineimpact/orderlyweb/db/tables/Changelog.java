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
import org.vaccineimpact.orderlyweb.db.tables.records.ChangelogRecord;


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
public class Changelog extends TableImpl<ChangelogRecord> {

    private static final long serialVersionUID = -270545310;

    /**
     * The reference instance of <code>changelog</code>
     */
    public static final Changelog CHANGELOG = new Changelog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ChangelogRecord> getRecordType() {
        return ChangelogRecord.class;
    }

    /**
     * The column <code>changelog.id</code>.
     */
    public final TableField<ChangelogRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>changelog.report_version</code>.
     */
    public final TableField<ChangelogRecord, String> REPORT_VERSION = createField("report_version", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>changelog.report_version_public</code>.
     */
    public final TableField<ChangelogRecord, String> REPORT_VERSION_PUBLIC = createField("report_version_public", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>changelog.label</code>.
     */
    public final TableField<ChangelogRecord, String> LABEL = createField("label", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>changelog.value</code>.
     */
    public final TableField<ChangelogRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>changelog.from_file</code>.
     */
    public final TableField<ChangelogRecord, Boolean> FROM_FILE = createField("from_file", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * Create a <code>changelog</code> table reference
     */
    public Changelog() {
        this("changelog", null);
    }

    /**
     * Create an aliased <code>changelog</code> table reference
     */
    public Changelog(String alias) {
        this(alias, CHANGELOG);
    }

    private Changelog(String alias, Table<ChangelogRecord> aliased) {
        this(alias, aliased, null);
    }

    private Changelog(String alias, Table<ChangelogRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<ChangelogRecord> getPrimaryKey() {
        return Keys.PK_CHANGELOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ChangelogRecord>> getKeys() {
        return Arrays.<UniqueKey<ChangelogRecord>>asList(Keys.PK_CHANGELOG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ChangelogRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ChangelogRecord, ?>>asList(Keys.FK_CHANGELOG_REPORT_VERSION_2, Keys.FK_CHANGELOG_REPORT_VERSION_1, Keys.FK_CHANGELOG_CHANGELOG_LABEL_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Changelog as(String alias) {
        return new Changelog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Changelog rename(String name) {
        return new Changelog(name, null);
    }
}
