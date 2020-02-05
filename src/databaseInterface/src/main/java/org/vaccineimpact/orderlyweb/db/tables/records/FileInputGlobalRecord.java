/*
 * This file is generated by jOOQ.
*/
package org.vaccineimpact.orderlyweb.db.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.vaccineimpact.orderlyweb.db.tables.FileInputGlobal;


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
public class FileInputGlobalRecord extends UpdatableRecordImpl<FileInputGlobalRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = -1321022974;

    /**
     * Setter for <code>file_input_global.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>file_input_global.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>file_input_global.file_input</code>.
     */
    public void setFileInput(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>file_input_global.file_input</code>.
     */
    public Integer getFileInput() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>file_input_global.filename</code>.
     */
    public void setFilename(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>file_input_global.filename</code>.
     */
    public String getFilename() {
        return (String) get(2);
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
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return FileInputGlobal.FILE_INPUT_GLOBAL.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return FileInputGlobal.FILE_INPUT_GLOBAL.FILE_INPUT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return FileInputGlobal.FILE_INPUT_GLOBAL.FILENAME;
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
    public Integer value2() {
        return getFileInput();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getFilename();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileInputGlobalRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileInputGlobalRecord value2(Integer value) {
        setFileInput(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileInputGlobalRecord value3(String value) {
        setFilename(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FileInputGlobalRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FileInputGlobalRecord
     */
    public FileInputGlobalRecord() {
        super(FileInputGlobal.FILE_INPUT_GLOBAL);
    }

    /**
     * Create a detached, initialised FileInputGlobalRecord
     */
    public FileInputGlobalRecord(Integer id, Integer fileInput, String filename) {
        super(FileInputGlobal.FILE_INPUT_GLOBAL);

        set(0, id);
        set(1, fileInput);
        set(2, filename);
    }
}
