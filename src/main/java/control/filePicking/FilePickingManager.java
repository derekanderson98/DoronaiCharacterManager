package control.filePicking;

import control.json.JsonInterpreter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FilePickingManager {
    public static final String FILE_SUFFIX = ".json";

    public static <ObjectType> ObjectType loadFile(Class<ObjectType> type) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileFilter() {
            public String getDescription() {
                return "JSON files (*.json)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".json");
                }
            }
        });
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());

        int loadResponse = fileChooser.showOpenDialog(null);
        if (loadResponse == JFileChooser.APPROVE_OPTION) {
            File loadFile = fileChooser.getSelectedFile();
            return JsonInterpreter.loadFile(loadFile, type);
        }
        else {
            return null;
        }
    }

    public static int saveFile(Object data) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileFilter() {
            public String getDescription() {
                return "JSON files (*.json)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".json");
                }
            }
        });
        fileChooser.removeChoosableFileFilter(fileChooser.getAcceptAllFileFilter());

        int saveResponse = fileChooser.showSaveDialog(null);
        if (saveResponse != JFileChooser.APPROVE_OPTION) {
            return saveResponse;
        }

        File file;
        if (!fileChooser.getSelectedFile().getAbsolutePath().endsWith(FILE_SUFFIX)) {
            file = new File(fileChooser.getSelectedFile() + ".json");
        }
        else {
            file = fileChooser.getSelectedFile();
        }

        String json = JsonInterpreter.serialize(data);
        try {
            if (!file.exists()) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(json);
                writer.close();
            }
            else {
                String message = "File \"" + file.getName() + "\" already exists in \n" + file.getParent() + ":\n" + "Do you want to overwrite?";
                String title = "Warning";
                int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION){
                    if (!file.delete()) return JFileChooser.ERROR_OPTION;
                    if (!file.createNewFile()) return JFileChooser.ERROR_OPTION;
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(json);
                    writer.close();
                }
                else {
                    return JFileChooser.CANCEL_OPTION;
                }
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            return JFileChooser.ERROR_OPTION;
        }

        return saveResponse;
    }
}
