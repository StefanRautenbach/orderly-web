/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import org.vaccineimpact.orderlyweb.db.tables.Parameters;


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
public class ParametersRecord extends UpdatableRecordImpl<ParametersRecord> implements Record5<Integer, String, String, String, String> {

    private static final long serialVersionUID = -1769452924;

    /**
     * Setter for <code>parameters.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>parameters.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>parameters.report_version</code>.
     */
    public void setReportVersion(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>parameters.report_version</code>.
     */
    public String getReportVersion() {
        return (String) get(1);
    }

    /**
     * Setter for <code>parameters.name</code>.
     */
    public void setName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>parameters.name</code>.
     */
    public String getName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>parameters.type</code>.
     */
    public void setType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>parameters.type</code>.
     */
    public String getType() {
        return (String) get(3);
    }

    /**
     * Setter for <code>parameters.value</code>.
     */
    public void setValue(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>parameters.value</code>.
     */
    public String getValue() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Parameters.PARAMETERS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Parameters.PARAMETERS.REPORT_VERSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Parameters.PARAMETERS.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Parameters.PARAMETERS.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Parameters.PARAMETERS.VALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getReportVersion();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametersRecord value2(String value) {
        setReportVersion(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametersRecord value3(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametersRecord value4(String value) {
        setType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametersRecord value5(String value) {
        setValue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ParametersRecord values(Integer value1, String value2, String value3, String value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ParametersRecord
     */
    public ParametersRecord() {
        super(Parameters.PARAMETERS);
    }

    /**
     * Create a detached, initialised ParametersRecord
     */
    public ParametersRecord(Integer id, String reportVersion, String name, String type, String value) {
        super(Parameters.PARAMETERS);

        set(0, id);
        set(1, reportVersion);
        set(2, name);
        set(3, type);
        set(4, value);
    }
}
