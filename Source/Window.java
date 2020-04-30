package Source;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;

public class Window extends JFrame {
  private static final long serialVersionUID = 1L;
  private Cola cola;

  private void readFiles() {

    // FILE READER
    FileDialog dialog = new FileDialog((Frame) null, "Selecciona archivo");
    dialog.setMode(FileDialog.LOAD);
    dialog.setVisible(true);

    // ARCHIVO
    File[] path = dialog.getFiles();

    try {
      // BUFFER
      BufferedReader buffer = new BufferedReader(new FileReader(path[0]));
      String st;
      while ((st = buffer.readLine()) != null) {
        Double res = new Notacion(st.split(",")).rpn();
        cola.push(st.split(",")[0] + " = " + Double.toString(res));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void genHTML() {
    String template = "<!DOCTYPE html><html><head> <meta charset='UTF-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Reporte</title> <style>*{padding: 0; margin: 0; box-sizing: border-box;}body{padding: 50px 100px; background: #eee; user-select: none; margin: 0; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif; -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale;}main{margin: 0 auto; position: relative; background: #fff; width: 100%; height: calc(100vh - 100px); border-radius: 20px; box-shadow: -10px -10px 10px rgba(255, 255, 255, .4), 10px 10px 10px rgba(0, 0, 0, .15);}svg{border-radius: 20px;}h1{color: #fff; position: absolute; top: 20px; left: 50px;}p{color: #fff; position: absolute; top: 60px; left: 50px; font-size: 1em; width: 400px;}ul{margin: -50px 0 0 70px; font-size: 2em; font-weight: bold;}img{width: 100px; position: absolute; bottom: 0; right: 0; margin: 20px;}#info{position: absolute; top: 0; right: 0; margin: 30px; color: #fff; font-weight: bold;}a{color: #eee;}</style></head><body> <main> <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1440 320'> <path fill='#0099ff' fill-opacity='1' d='M0,224L48,229.3C96,235,192,245,288,229.3C384,213,480,171,576,176C672,181,768,235,864,240C960,245,1056,203,1152,208C1248,213,1344,267,1392,293.3L1440,320L1440,0L1392,0C1344,0,1248,0,1152,0C1056,0,960,0,864,0C768,0,672,0,576,0C480,0,384,0,288,0C192,0,96,0,48,0L0,0Z'> </path> </svg> <h1>Reporte de Calculo:</h1> <p>En este apartado se generara el reporte de calculo Alex Daniel Santos Valenzuela: 201904117 y Gerson Aaron Quinia Folgar: 201904157</p><div id='info'> <span>Alex Santos </span><a href='https://github.com/alexsan-dev' target='_blank'>https://github.com/alexsan-dev</a><br/> <span>Gerson Quinia </span><a href='https://github.com/GQ202/' target='_blank'>https://github.com/GQ202/</a> </div><img src='https://ingenieria.usac.app/static/img/logo-512x512.png' alt='logo'/> <ul>";

    for (int i = 0; i < cola.size(); i++)
      template += "<li>" + cola.get(i) + "</li>";

    String finalTemp = template + "</ul></main></body></html>";

    try {
      FileWriter myWriter = new FileWriter("reporte.html");
      myWriter.write(finalTemp);
      myWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void genCustomHTML() {
    String[] opt = JOptionPane.showInputDialog(null, "Ingresa el identificador").split(",");

    String template = "<!DOCTYPE html><html><head> <meta charset='UTF-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Reporte</title> <style>*{padding: 0; margin: 0; box-sizing: border-box;}body{padding: 50px 100px; background: #eee; user-select: none; margin: 0; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Roboto', 'Oxygen', 'Ubuntu', 'Cantarell', 'Fira Sans', 'Droid Sans', 'Helvetica Neue', sans-serif; -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale;}main{margin: 0 auto; position: relative; background: #fff; width: 100%; height: calc(100vh - 100px); border-radius: 20px; box-shadow: -10px -10px 10px rgba(255, 255, 255, .4), 10px 10px 10px rgba(0, 0, 0, .15);}svg{border-radius: 20px;}h1{color: #fff; position: absolute; top: 20px; left: 50px;}p{color: #fff; position: absolute; top: 60px; left: 50px; font-size: 1em; width: 400px;}ul{margin: -50px 0 0 70px; font-size: 2em; font-weight: bold;}img{width: 100px; position: absolute; bottom: 0; right: 0; margin: 20px;}#info{position: absolute; top: 0; right: 0; margin: 30px; color: #fff; font-weight: bold;}a{color: #eee;}</style></head><body> <main> <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1440 320'> <path fill='#0099ff' fill-opacity='1' d='M0,224L48,229.3C96,235,192,245,288,229.3C384,213,480,171,576,176C672,181,768,235,864,240C960,245,1056,203,1152,208C1248,213,1344,267,1392,293.3L1440,320L1440,0L1392,0C1344,0,1248,0,1152,0C1056,0,960,0,864,0C768,0,672,0,576,0C480,0,384,0,288,0C192,0,96,0,48,0L0,0Z'> </path> </svg> <h1>Reporte de Calculo:</h1> <p>En este apartado se generara el reporte de calculo Alex Daniel Santos Valenzuela: 201904117 y Gerson Aaron Quinia Folgar: 201904157</p><div id='info'> <span>Alex Santos </span><a href='https://github.com/alexsan-dev' target='_blank'>https://github.com/alexsan-dev</a><br/> <span>Gerson Quinia </span><a href='https://github.com/GQ202/' target='_blank'>https://github.com/GQ202/</a> </div><img src='https://ingenieria.usac.app/static/img/logo-512x512.png' alt='logo'/> <ul>";

    for (int i = 0; i < cola.size(); i++) {
      for (int j = 0; j < opt.length; j++) {
        if (cola.get(i).contains(opt[j]))
          template += "<li>" + cola.get(i) + "</li>";
      }
    }

    String finalTemp = template + "</ul></main></body></html>";

    try {
      FileWriter myWriter = new FileWriter("reporte.html");
      myWriter.write(finalTemp);
      myWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Window() {
    super("Practica 2");
    setVisible(true);
    setSize(600, 100);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    cola = new Cola();

    // COMPONENTES
    Button openFile = new Button("Abrir archivo");
    Button genFiles = new Button("Generar reporte");
    Button genReport = new Button("Reporte personalizado");

    openFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        readFiles();
      }
    });

    genFiles.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        genHTML();
      }
    });

    genReport.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        genCustomHTML();
      }
    });

    add(openFile);
    add(genFiles);
    add(genReport);
  }
}