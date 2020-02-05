/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;
import org.vaccineimpact.orderlyweb.db.tables.OrderlywebDocument;


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
public class OrderlywebDocumentRecord extends UpdatableRecordImpl<OrderlywebDocumentRecord> implements Record6<Integer, String, Integer, String, String, String> {

    private static final long serialVersionUID = -1895578904;

    /**
     * Setter for <code>orderlyweb_document.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>orderlyweb_document.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>orderlyweb_document.filename</code>.
     */
    public void setFilename(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>orderlyweb_document.filename</code>.
     */
    public String getFilename() {
        return (String) get(1);
    }

    /**
     * Setter for <code>orderlyweb_document.show</code>.
     */
    public void setShow(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>orderlyweb_document.show</code>.
     */
    public Integer getShow() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>orderlyweb_document.display_name</code>.
     */
    public void setDisplayName(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>orderlyweb_document.display_name</code>.
     */
    public String getDisplayName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>orderlyweb_document.description</code>.
     */
    public void setDescription(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>orderlyweb_document.description</code>.
     */
    public String getDescription() {
        return (String) get(4);
    }

    /**
     * Setter for <code>orderlyweb_document.parent</code>.
     */
    public void setParent(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>orderlyweb_document.parent</code>.
     */
    public String getParent() {
        return (String) get(5);
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
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, Integer, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<Integer, String, Integer, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return OrderlywebDocument.ORDERLYWEB_DOCUMENT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return OrderlywebDocument.ORDERLYWEB_DOCUMENT.FILENAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return OrderlywebDocument.ORDERLYWEB_DOCUMENT.SHOW;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return OrderlywebDocument.ORDERLYWEB_DOCUMENT.DISPLAY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return OrderlywebDocument.ORDERLYWEB_DOCUMENT.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return OrderlywebDocument.ORDERLYWEB_DOCUMENT.PARENT;
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
        return getFilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getShow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getDisplayName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getParent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebDocumentRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebDocumentRecord value2(String value) {
        setFilename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebDocumentRecord value3(Integer value) {
        setShow(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebDocumentRecord value4(String value) {
        setDisplayName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebDocumentRecord value5(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebDocumentRecord value6(String value) {
        setParent(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrderlywebDocumentRecord values(Integer value1, String value2, Integer value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrderlywebDocumentRecord
     */
    public OrderlywebDocumentRecord() {
        super(OrderlywebDocument.ORDERLYWEB_DOCUMENT);
    }

    /**
     * Create a detached, initialised OrderlywebDocumentRecord
     */
    public OrderlywebDocumentRecord(Integer id, String filename, Integer show, String displayName, String description, String parent) {
        super(OrderlywebDocument.ORDERLYWEB_DOCUMENT);

        set(0, id);
        set(1, filename);
        set(2, show);
        set(3, displayName);
        set(4, description);
        set(5, parent);
    }
}
