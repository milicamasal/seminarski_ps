/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Movie;
import domain.MovieTheater;
import domain.Projection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Milica i Nikola
 */
public class TableModelProjection extends AbstractTableModel {

    List<Projection> projections;
    private String[] columnNames = new String[]{"Movie", "Theater", "Time", "Date", "Screen"};
    private Class[] columnTypes = new Class[]{Movie.class, MovieTheater.class, LocalTime.class, LocalDate.class, String.class};

    public TableModelProjection(List<Projection> projections) {
        this.projections = projections;
    }

    @Override
    public int getRowCount() {
        return projections.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Projection projection = projections.get(row);
        switch (column) {
            case 0:
                return projection.getMovie().getTitle();
            case 1:
                return projection.getTheater().getName();
            case 2:
                return projection.getTime();
            case 3:
                return projection.getDate();
            case 4:
                return projection.getScreen();
            default:
                return "N/A";
        }

    }

    public Class<?> getColumnClass(int columnIndex) {
        return columnTypes[columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
     public Projection getProjection(int index) {
        return projections.get(index);
    }
    

}
