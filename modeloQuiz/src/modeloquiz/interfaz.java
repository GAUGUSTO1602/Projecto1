package modeloquiz;

import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author veronica
 */
public class interfaz extends javax.swing.JFrame {
Lista L;
Contador count;
    /**
     * Creates new form interfaz
     */
    public interfaz() {
        this.L = new Lista <>("Mi lista");
        this.count = new Contador();
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JOptionPane.showMessageDialog(null, "Bienvenido al creador de listas simples enlazadas. "
 + "\n Aqui podras crear una lista mientras añades nodos uno por uno. "
 + "\n También podras enlazar el ultimo nodo añadido a un nodo ya creado. "
 + "\n Tenga en cuenta que para lo anterior debera indicar el nodo al cual desea enlazar"
 + "\n Cada nodo posee un numero que corresponde al orden en el cual se crearon (el primer nodo es el uno, el segundo el dos y asi) "
 + "\n Consulte la opcion 'Tamaño de la lista' para comprobar cuantos nodos se han creado");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        insertarNodo = new javax.swing.JToggleButton();
        tamanioLista = new javax.swing.JButton();
        vaciar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        evaluar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insertarNodo.setText("Insertar nodo");
        insertarNodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarNodoActionPerformed(evt);
            }
        });
        jPanel1.add(insertarNodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 120, -1));

        tamanioLista.setText("Tamaño de la lista");
        tamanioLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tamanioListaActionPerformed(evt);
            }
        });
        jPanel1.add(tamanioLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        vaciar.setText("Vaciar lista");
        vaciar.setToolTipText("");
        vaciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaciarActionPerformed(evt);
            }
        });
        jPanel1.add(vaciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 120, -1));

        jToggleButton1.setText("Insertar y enlazar a un nodo");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        jPanel1.add(input, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 150, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        evaluar.setText("Evaluar lista");
        evaluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluarActionPerformed(evt);
            }
        });
        jPanel1.add(evaluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertarNodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarNodoActionPerformed

        // TODO add your handling code here:
        this.L.insertarAlFinal(false, 0);

            
    }//GEN-LAST:event_insertarNodoActionPerformed

    private void tamanioListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tamanioListaActionPerformed
        // TODO add your handling code here:
        this.L.tamanioLista(true);
    }//GEN-LAST:event_tamanioListaActionPerformed

    private void vaciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarActionPerformed
        // TODO add your handling code here:
        this.L.vaciar();
    }//GEN-LAST:event_vaciarActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Integer num = Integer.parseInt(input.getText());
            if(L.esVacio()){
                JOptionPane.showMessageDialog(null, "Lista vacia. No hay nodos a cual enlazar");
            } else if(num <= this.L.tamanioLista(false)){
                this.L.insertarAlFinal(true, num);
            } else{
                JOptionPane.showMessageDialog(null, "Error. valor ingresado no valido");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, valor ingresado no valido");
        }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void evaluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluarActionPerformed
        // TODO add your handling code here:
        if (!this.L.esCiclo()){
            JOptionPane.showMessageDialog(null, "La lista actual no forma un ciclo");
        } else {
            JOptionPane.showMessageDialog(null, "La lista actual forma un ciclo");
        }
    }//GEN-LAST:event_evaluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton evaluar;
    private javax.swing.JTextField input;
    private javax.swing.JToggleButton insertarNodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton tamanioLista;
    private javax.swing.JButton vaciar;
    // End of variables declaration//GEN-END:variables
}
