/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Actor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica i Nikola
 */
public class TableModelLeadCast extends AbstractTableModel {

    private List<Actor> leadCast;
    private String[] columnNames = new String[]{"First name", "Last name", "Role"};
    private Class[] columnTypes = new Class[]{String.class, String.class, String.class};

    public TableModelLeadCast(List<Actor> leadCast) {
        this.leadCast = leadCast;
    }

    @Override
    public int getRowCount() {
        return leadCast.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Actor actor = leadCast.get(row);
        switch (column) {
            case 0:
                return actor.getFirstName();
            case 1:
                return actor.getLastName();
            case 2:
                return actor.getRole();
            default:
                return "n/a";

        }

    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        Actor actor = leadCast.get(row);
        switch (column) {
            case 0:
                actor.setFirstName(value.toString());
                break;
            case 1:
                actor.setLastName(value.toString());
                break;
            case 2:
                actor.setRole(value.toString());
                break;

        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    public void removeActor(int rowIndex) {
        leadCast.remove(rowIndex);
        fireTableRowsDeleted(leadCast.size() - 1, leadCast.size() - 1);
    }

}
