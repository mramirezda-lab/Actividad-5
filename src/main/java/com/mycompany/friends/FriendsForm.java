/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.friends;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
/**
 *
 * @author Migue
 */
public class FriendsForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FriendsForm.class.getName());

    /**
     * Creates new form FriendsForm
     */
    public FriendsForm() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Create = new javax.swing.JButton();
        Read = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        Nombre = new javax.swing.JLabel();
        Número = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        Clean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Read.setText("Read");
        Read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Nombre.setText("Name:");

        Número.setText("Number:");

        Clean.setText("Clean Fields");
        Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Create)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Número, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Read)
                        .addGap(18, 18, 18)
                        .addComponent(Update)
                        .addGap(18, 18, 18)
                        .addComponent(Delete))
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Clean)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Número))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Create)
                    .addComponent(Read)
                    .addComponent(Update)
                    .addComponent(Delete)
                    .addComponent(Clean))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateActionPerformed
          try {
        String newName = txtName.getText().trim();
        long newNumber = Long.parseLong(txtNumber.getText().trim());

        File file = new File("friendsContact.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        // Check duplicates
        String line;
        while (raf.getFilePointer() < raf.length()) {
            line = raf.readLine();
            if (line == null || line.isEmpty()) continue;
            String[] parts = line.split("!");
            if (parts.length >= 1 && parts[0].equals(newName)) {
                JOptionPane.showMessageDialog(this, "This name already exists!");
                raf.close();
                return;
            }
        }

        // append
        raf.writeBytes(newName + "!" + newNumber + "\n");
        raf.close();
        JOptionPane.showMessageDialog(this, "Contact added!");
    } catch (IOException ioe) {
        JOptionPane.showMessageDialog(this, "An error occurred.");
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Invalid number format.");
    }                            
   

    }//GEN-LAST:event_CreateActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
          try {

        String nameNumberString;
        String name;
        String newName = txtName.getText().trim();
        long newNumber = Long.parseLong(txtNumber.getText().trim());

        File file = new File("friendsContact.txt");

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "No contact file found.");
            return;
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        boolean found = false;

        File tmpFile = new File("temp.txt");
        RandomAccessFile tmpRaf = new RandomAccessFile(tmpFile, "rw");

        while (raf.getFilePointer() < raf.length()) {

            nameNumberString = raf.readLine();
            String[] lineSplit = nameNumberString.split("!");

            name = lineSplit[0];
            long number = Long.parseLong(lineSplit[1]);

            if (name.equals(newName)) {
                tmpRaf.writeBytes(newName + "!" + newNumber + "\n");
                found = true;
            } else {
                tmpRaf.writeBytes(name + "!" + number + "\n");
            }
        }

        raf.close();
        tmpRaf.close();

        if (!file.delete()) {
            JOptionPane.showMessageDialog(null, "Error updating file.");
            return;
        }

        if (!tmpFile.renameTo(file)) {
            JOptionPane.showMessageDialog(null, "Error finalizing update.");
            return;
        }

        if (found) {
            JOptionPane.showMessageDialog(null, "Contact updated successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Name not found, cannot update.");
        }

    } catch (IOException ioe) {
        JOptionPane.showMessageDialog(null, "An error occurred.");
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(null, "Invalid number format.");
    }
    }//GEN-LAST:event_UpdateActionPerformed

    private void ReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReadActionPerformed
        try {

        String nameNumberString;
        String name;
        String searchName= String.valueOf(txtName.getText());
        long number;

        File file = new File("friendsContact.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        while (raf.getFilePointer() < raf.length()) {
            nameNumberString = raf.readLine();
            String[] lineSplit= nameNumberString.split("!");
            name = lineSplit[0];
            number = Long.parseLong(lineSplit[1]);
        
        if (name.equals(searchName)){
            txtName.setText(String.valueOf(name));
            txtNumber.setText(String.valueOf(number));
            raf.close(); 
            JOptionPane.showMessageDialog(null, "the name was found");
        }
        else{
        JOptionPane.showMessageDialog(null, "the name was not found");
        txtName.setText("");
        txtNumber.setText("");
            }
        }
    }

        
        catch (IOException ioe)
            {
                
                JOptionPane.showMessageDialog(null, "An error has occurred");
            }
            catch (NumberFormatException nef)
            {
                JOptionPane.showMessageDialog(null, "A number Format Error has occurred");
            }
    }//GEN-LAST:event_ReadActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        try {
        String deleteName = txtName.getText().trim();

        File file = new File("friendsContact.txt");

        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "No contact file found.");
            return;
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        boolean found = false;

        File tmpFile = new File("temp.txt");
        RandomAccessFile tmpRaf = new RandomAccessFile(tmpFile, "rw");

        String nameNumberString;
        while (raf.getFilePointer() < raf.length()) {
            nameNumberString = raf.readLine();
            if (nameNumberString == null || nameNumberString.isEmpty()) continue;
            String[] lineSplit = nameNumberString.split("!");
            if (lineSplit.length < 2) continue;

            String name = lineSplit[0];
            long number = Long.parseLong(lineSplit[1]);

            if (name.equals(deleteName)) {
                found = true; // skip copying this one
            } else {
                tmpRaf.writeBytes(name + "!" + number + "\n");
            }
        }

        raf.close();
        tmpRaf.close();

        if (!file.delete()) {
            JOptionPane.showMessageDialog(this, "Error deleting original file.");
            return;
        }
        if (!tmpFile.renameTo(file)) {
            JOptionPane.showMessageDialog(this, "Error finalizing delete.");
            return;
        }

        if (found) {
            JOptionPane.showMessageDialog(this, "Contact deleted!");
            txtName.setText("");
            txtNumber.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Input name does not exists");
        }

    } catch (IOException ioe) {
        JOptionPane.showMessageDialog(this, "An error occurred.");
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Invalid number format.");
    }
    }//GEN-LAST:event_DeleteActionPerformed

    private void CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanActionPerformed
                                       
    txtName.setText("");
    txtNumber.setText("");


    }//GEN-LAST:event_CleanActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> new FriendsForm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clean;
    private javax.swing.JButton Create;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Número;
    private javax.swing.JButton Read;
    private javax.swing.JButton Update;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}
