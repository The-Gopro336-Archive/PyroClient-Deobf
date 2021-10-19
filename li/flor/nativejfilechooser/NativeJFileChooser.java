package li.flor.nativejfilechooser;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class NativeJFileChooser extends JFileChooser {
   public static final boolean FX_AVAILABLE;
   private List currentFiles;
   private FileChooser fileChooser;
   private File currentFile;
   private DirectoryChooser directoryChooser;

   public NativeJFileChooser() {
      this.initFxFileChooser((File)null);
   }

   public NativeJFileChooser(String currentDirectoryPath) {
      super(currentDirectoryPath);
      this.initFxFileChooser(new File(currentDirectoryPath));
   }

   public NativeJFileChooser(File currentDirectory) {
      super(currentDirectory);
      this.initFxFileChooser(currentDirectory);
   }

   public NativeJFileChooser(FileSystemView fsv) {
      super(fsv);
      this.initFxFileChooser(fsv.getDefaultDirectory());
   }

   public NativeJFileChooser(File currentDirectory, FileSystemView fsv) {
      super(currentDirectory, fsv);
      this.initFxFileChooser(currentDirectory);
   }

   public NativeJFileChooser(String currentDirectoryPath, FileSystemView fsv) {
      super(currentDirectoryPath, fsv);
      this.initFxFileChooser(new File(currentDirectoryPath));
   }

   public int showOpenDialog(final Component parent) throws HeadlessException {
      if (!FX_AVAILABLE) {
         return super.showOpenDialog(parent);
      } else {
         final CountDownLatch latch = new CountDownLatch(1);
         Platform.runLater(new Runnable() {
            public void run() {
               if (parent != null) {
                  parent.setEnabled(false);
               }

               if (NativeJFileChooser.this.isDirectorySelectionEnabled()) {
                  NativeJFileChooser.this.currentFile = NativeJFileChooser.this.directoryChooser.showDialog((Window)null);
               } else if (NativeJFileChooser.this.isMultiSelectionEnabled()) {
                  NativeJFileChooser.this.currentFiles = NativeJFileChooser.this.fileChooser.showOpenMultipleDialog((Window)null);
               } else {
                  NativeJFileChooser.this.currentFile = NativeJFileChooser.this.fileChooser.showOpenDialog((Window)null);
               }

               latch.countDown();
            }
         });

         try {
            latch.await();
         } catch (InterruptedException var7) {
            throw new RuntimeException(var7);
         } finally {
            if (parent != null) {
               parent.setEnabled(true);
            }

         }

         if (this.isMultiSelectionEnabled()) {
            return this.currentFiles != null ? 0 : 1;
         } else {
            return this.currentFile != null ? 0 : 1;
         }
      }
   }

   public int showSaveDialog(final Component parent) throws HeadlessException {
      if (!FX_AVAILABLE) {
         return super.showSaveDialog(parent);
      } else {
         final CountDownLatch latch = new CountDownLatch(1);
         Platform.runLater(new Runnable() {
            public void run() {
               if (parent != null) {
                  parent.setEnabled(false);
               }

               if (NativeJFileChooser.this.isDirectorySelectionEnabled()) {
                  NativeJFileChooser.this.currentFile = NativeJFileChooser.this.directoryChooser.showDialog((Window)null);
               } else {
                  NativeJFileChooser.this.currentFile = NativeJFileChooser.this.fileChooser.showSaveDialog((Window)null);
               }

               latch.countDown();
            }
         });

         try {
            latch.await();
         } catch (InterruptedException var7) {
            throw new RuntimeException(var7);
         } finally {
            if (parent != null) {
               parent.setEnabled(true);
            }

         }

         return this.currentFile != null ? 0 : 1;
      }
   }

   public int showDialog(Component parent, String approveButtonText) {
      return !FX_AVAILABLE ? super.showDialog(parent, approveButtonText) : this.showOpenDialog(parent);
   }

   public File[] getSelectedFiles() {
      if (!FX_AVAILABLE) {
         return super.getSelectedFiles();
      } else {
         return this.currentFiles == null ? null : (File[])this.currentFiles.toArray(new File[this.currentFiles.size()]);
      }
   }

   public File getSelectedFile() {
      return !FX_AVAILABLE ? super.getSelectedFile() : this.currentFile;
   }

   public void setSelectedFiles(File[] selectedFiles) {
      if (!FX_AVAILABLE) {
         super.setSelectedFiles(selectedFiles);
      } else {
         if (selectedFiles != null && selectedFiles.length != 0) {
            this.setSelectedFile(selectedFiles[0]);
            this.currentFiles = new ArrayList(Arrays.asList(selectedFiles));
         } else {
            this.currentFiles = null;
         }

      }
   }

   public void setSelectedFile(File file) {
      if (!FX_AVAILABLE) {
         super.setSelectedFile(file);
      } else {
         this.currentFile = file;
         if (file != null) {
            if (file.isDirectory()) {
               this.fileChooser.setInitialDirectory(file.getAbsoluteFile());
               if (this.directoryChooser != null) {
                  this.directoryChooser.setInitialDirectory(file.getAbsoluteFile());
               }
            } else if (file.isFile()) {
               this.fileChooser.setInitialDirectory(file.getParentFile());
               this.fileChooser.setInitialFileName(file.getName());
               if (this.directoryChooser != null) {
                  this.directoryChooser.setInitialDirectory(file.getParentFile());
               }
            }
         }

      }
   }

   public void setFileSelectionMode(int mode) {
      super.setFileSelectionMode(mode);
      if (FX_AVAILABLE) {
         if (mode == 1) {
            if (this.directoryChooser == null) {
               this.directoryChooser = new DirectoryChooser();
            }

            this.setSelectedFile(this.currentFile);
            this.setDialogTitle(this.getDialogTitle());
         }

      }
   }

   public void setDialogTitle(String dialogTitle) {
      if (!FX_AVAILABLE) {
         super.setDialogTitle(dialogTitle);
      } else {
         this.fileChooser.setTitle(dialogTitle);
         if (this.directoryChooser != null) {
            this.directoryChooser.setTitle(dialogTitle);
         }

      }
   }

   public String getDialogTitle() {
      return !FX_AVAILABLE ? super.getDialogTitle() : this.fileChooser.getTitle();
   }

   public void changeToParentDirectory() {
      if (!FX_AVAILABLE) {
         super.changeToParentDirectory();
      } else {
         File parentDir = this.fileChooser.getInitialDirectory().getParentFile();
         if (parentDir.isDirectory()) {
            this.fileChooser.setInitialDirectory(parentDir);
            if (this.directoryChooser != null) {
               this.directoryChooser.setInitialDirectory(parentDir);
            }
         }

      }
   }

   public void addChoosableFileFilter(FileFilter filter) {
      super.addChoosableFileFilter(filter);
      if (FX_AVAILABLE && filter != null) {
         if (filter.getClass().equals(FileNameExtensionFilter.class)) {
            FileNameExtensionFilter f = (FileNameExtensionFilter)filter;
            List ext = new ArrayList();
            String[] var4 = f.getExtensions();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               String extension = var4[var6];
               ext.add(extension.replaceAll("^\\*?\\.?(.*)$", "*.$1"));
            }

            this.fileChooser.getExtensionFilters().add(new ExtensionFilter(f.getDescription(), ext));
         }

      }
   }

   public void setAcceptAllFileFilterUsed(boolean bool) {
      boolean differs = this.isAcceptAllFileFilterUsed() ^ bool;
      super.setAcceptAllFileFilterUsed(bool);
      if (FX_AVAILABLE) {
         if (differs) {
            if (bool) {
               this.fileChooser.getExtensionFilters().add(new ExtensionFilter("All files", new String[]{"*.*"}));
            } else {
               Iterator it = this.fileChooser.getExtensionFilters().iterator();

               while(it.hasNext()) {
                  ExtensionFilter filter = (ExtensionFilter)it.next();
                  if (filter.getExtensions().size() == 1 && filter.getExtensions().contains("*.*")) {
                     it.remove();
                  }
               }
            }

         }
      }
   }

   private void initFxFileChooser(File currentFile) {
      if (FX_AVAILABLE) {
         this.fileChooser = new FileChooser();
         this.currentFile = currentFile;
         this.setSelectedFile(currentFile);
      }

   }

   static {
      boolean isFx;
      try {
         Class.forName("javafx.stage.FileChooser");
         isFx = true;
         new JFXPanel();
      } catch (ClassNotFoundException var2) {
         isFx = false;
      }

      FX_AVAILABLE = isFx;
   }
}
