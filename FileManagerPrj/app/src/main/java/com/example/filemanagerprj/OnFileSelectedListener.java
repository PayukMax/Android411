package com.example.filemanagerprj;

import java.io.File;

public interface OnFileSelectedListener {
    void onFileClicked(File file);
    void onFileLongClocked (File file, int position);
}
