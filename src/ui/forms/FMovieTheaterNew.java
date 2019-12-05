/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.forms;

import controller.Controller;
import domain.MovieTheater;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Milica i Nikola
 */
public class FMovieTheaterNew extends javax.swing.JDialog {

    /**
     * Creates new form FMovieTheaterNew
     */
    public FMovieTheaterNew(java.awt.Frame parent, boolean modal, FormMode formmode) {
        super(parent, modal);
        initComponents();
        prepareView(formmode);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtMovieTheaterName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtMovieTheaterAdress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jbtnSave = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jlblChooseMovieTheater = new javax.swing.JLabel();
        jbtnChange = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jtxtMovieTheaterID = new javax.swing.JLabel();
        jbtnAddAnother = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jcmbboxAllMovieTheaters = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Movie Theater ID:");

        jLabel2.setText("Name:");

        jLabel3.setText("Adress:");

        jbtnSave.setText("Save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jlblChooseMovieTheater.setText("Choose movie theater:");

        jbtnChange.setText("Change");
        jbtnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnChangeActionPerformed(evt);
            }
        });

        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnAddAnother.setText("Add another");
        jbtnAddAnother.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddAnotherActionPerformed(evt);
            }
        });

        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jcmbboxAllMovieTheaters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmbboxAllMovieTheatersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jlblChooseMovieTheater, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcmbboxAllMovieTheaters, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jbtnChange))
                            .addComponent(jtxtMovieTheaterID, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(98, 98, 98)
                                .addComponent(jtxtMovieTheaterName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(92, 92, 92)
                                .addComponent(jtxtMovieTheaterAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnDelete)
                        .addGap(36, 36, 36)
                        .addComponent(jbtnAddAnother)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnSave)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlblChooseMovieTheater)
                            .addComponent(jcmbboxAllMovieTheaters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbtnChange))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jtxtMovieTheaterID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(jtxtMovieTheaterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(jtxtMovieTheaterAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnSave)
                            .addComponent(jbtnUpdate)
                            .addComponent(jbtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnAddAnother)
                            .addComponent(jbtnDelete))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        String name = jtxtMovieTheaterName.getText();
        String adress = jtxtMovieTheaterAdress.getText();
        if (adress.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled in!");
        } else {
            MovieTheater movieTheater = new MovieTheater(name, adress);
            Controller.getInstance().saveMovieTheater(movieTheater);
            fillMovieTheater(movieTheater);
            JOptionPane.showMessageDialog(null, "Movie theater " + movieTheater.getName() + " is saved!");
            jbtnAddAnother.setVisible(true);
            jbtnSave.setVisible(false);
        }
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnChangeActionPerformed
        this.prepareView(FormMode.FORM_UPDATE);
    }//GEN-LAST:event_jbtnChangeActionPerformed

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCancelActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        MovieTheater mt = new MovieTheater(Long.parseLong(jtxtMovieTheaterID.getText()), jtxtMovieTheaterName.getText(), jtxtMovieTheaterAdress.getText());
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this movie theater?");
        if (answer == 0) {
            mt = Controller.getInstance().updateMovieTheater(mt);
            JOptionPane.showMessageDialog(null, "Movie theater has been successfully changed!");

        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnAddAnotherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddAnotherActionPerformed
        jtxtMovieTheaterID.setText("");
        jtxtMovieTheaterName.setText("");
        jtxtMovieTheaterAdress.setText("");

        prepareView(FormMode.FORM_ADD);
    }//GEN-LAST:event_jbtnAddAnotherActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        MovieTheater movieTheater = (MovieTheater) jcmbboxAllMovieTheaters.getSelectedItem();
        if (movieTheater != null) {
            Controller.getInstance().deleteMovieTheater(movieTheater);
            JOptionPane.showMessageDialog(null, "Movie theater " + movieTheater.getName() + "has been deleted!");
            prepareView(FormMode.FORM_VIEW);
        } else {
            JOptionPane.showMessageDialog(null, "Choose movie theater that you want to delete!");
            jcmbboxAllMovieTheaters.setBorder(BorderFactory.createLineBorder(Color.RED, 5));
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jcmbboxAllMovieTheatersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmbboxAllMovieTheatersActionPerformed
        MovieTheater selectedMovieTheater = (MovieTheater) jcmbboxAllMovieTheaters.getSelectedItem();
        if (selectedMovieTheater != null) {
            Controller.getInstance().getMap().put("current_movietheater", selectedMovieTheater);
            fillMovieTheater(selectedMovieTheater);
//            this.prepareView(FormMode.FORM_VIEW);
        }
    }//GEN-LAST:event_jcmbboxAllMovieTheatersActionPerformed

    
    public void prepareView(FormMode formMode) {

        setLocationRelativeTo(null);
        if (formMode.equals(FormMode.FORM_ADD)) {
            jbtnSave.setVisible(true);
            jlblChooseMovieTheater.setVisible(false);
            jcmbboxAllMovieTheaters.setVisible(false);
            jtxtMovieTheaterAdress.setEditable(true);
            jtxtMovieTheaterName.setEditable(true);
            jbtnChange.setVisible(false);
            jbtnUpdate.setVisible(false);
            jbtnAddAnother.setVisible(false);
            jbtnDelete.setVisible(false);
        }

        if (formMode.equals(FormMode.FORM_UPDATE)) {
            jlblChooseMovieTheater.setVisible(true);
            jcmbboxAllMovieTheaters.setVisible(true);
            jtxtMovieTheaterAdress.setEditable(true);
            jtxtMovieTheaterName.setEditable(true);
            jbtnSave.setVisible(false);
            jbtnUpdate.setVisible(true);
            jbtnAddAnother.setVisible(false);
            jbtnDelete.setVisible(true);

        }
        if (formMode.equals(FormMode.FORM_VIEW)) {
            jlblChooseMovieTheater.setVisible(true);

            fillComboBoxWithMovieTheaters();
            jbtnAddAnother.setVisible(true);
            jbtnChange.setVisible(true);
            jcmbboxAllMovieTheaters.setVisible(true);
            jtxtMovieTheaterAdress.setEditable(false);
            jtxtMovieTheaterName.setEditable(false);
            jbtnSave.setVisible(false);
            jbtnUpdate.setVisible(false);
            jbtnAddAnother.setVisible(false);
            jbtnDelete.setVisible(true);
        }

    }

    private void fillComboBoxWithMovieTheaters() {
        jcmbboxAllMovieTheaters.removeAllItems();
        for (MovieTheater mt : Controller.getInstance().getAllMovieTheaters()) {
            jcmbboxAllMovieTheaters.addItem(mt);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnAddAnother;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnChange;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JComboBox<MovieTheater> jcmbboxAllMovieTheaters;
    private javax.swing.JLabel jlblChooseMovieTheater;
    private javax.swing.JTextField jtxtMovieTheaterAdress;
    private javax.swing.JLabel jtxtMovieTheaterID;
    private javax.swing.JTextField jtxtMovieTheaterName;
    // End of variables declaration//GEN-END:variables

    private void fillMovieTheater(MovieTheater selectedMovieTheater) {
        jtxtMovieTheaterID.setText(selectedMovieTheater.getMovieTheaterID() + "");
        jtxtMovieTheaterName.setText(selectedMovieTheater.getName());
        jtxtMovieTheaterAdress.setText(selectedMovieTheater.getAdress());
    }
}
