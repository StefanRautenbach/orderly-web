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
import org.jooq.impl.TableImpl;
import org.vaccineimpact.orderlyweb.db.DefaultSchema;
import org.vaccineimpact.orderlyweb.db.Keys;
import org.vaccineimpact.orderlyweb.db.tables.records.OrderlywebUserGroupVersionPermissionRecord;


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
public class OrderlywebUserGroupVersionPermission extends TableImpl<OrderlywebUserGroupVersionPermissionRecord> {

    private static final long serialVersionUID = -1020863806;

    /**
     * The reference instance of <code>orderlyweb_user_group_version_permission</code>
     */
    public static final OrderlywebUserGroupVersionPermission ORDERLYWEB_USER_GROUP_VERSION_PERMISSION = new OrderlywebUserGroupVersionPermission();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OrderlywebUserGroupVersionPermissionRecord> getRecordType() {
        return OrderlywebUserGroupVersionPermissionRecord.class;
    }

    /**
     * The column <code>orderlyweb_user_group_version_permission.id</code>.
     */
    public final TableField<OrderlywebUserGroupVersionPermissionRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>orderlyweb_user_group_version_permission.version</code>.
     */
    public final TableField<OrderlywebUserGroupVersionPermissionRecord, String> VERSION = createField("version", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>orderlyweb_user_group_version_permission</code> table reference
     */
    public OrderlywebUserGroupVersionPermission() {
        this("orderlyweb_user_group_version_permission", null);
    }

    /**
     * Create an aliased <code>orderlyweb_user_group_version_permission</code> table reference
     */
    public OrderlywebUserGroupVersionPermission(String alias) {
        this(alias, ORDERLYWEB_USER_GROUP_VERSION_PERMISSION);
    }

    private OrderlywebUserGroupVersionPermission(String alias, Table<OrderlywebUserGroupVersionPermissionRecord> aliased) {
        this(alias, aliased, null);
    }

    private OrderlywebUserGroupVersionPermission(String alias, Table<OrderlywebUserGroupVersionPermissionRecord> aliased, Field<?>[] parameters) {
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
    public List<ForeignKey<OrderlywebUserGroupVersionPermissionRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<OrderlywebUserGroupVersionPermissionRecord, ?>>asList(Keys.FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_ORDERLYWEB_USER_GROUP_PERMISSION_1, Keys.FK_ORDERLYWEB_USER_GROUP_VERSION_PERMISSION_REPORT_VERSION_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebUserGroupVersionPermission as(String alias) {
        return new OrderlywebUserGroupVersionPermission(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OrderlywebUserGroupVersionPermission rename(String name) {
        return new OrderlywebUserGroupVersionPermission(name, null);
    }
}