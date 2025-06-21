package com.example.filemanagerprj.fragments;

import static android.content.Context.STORAGE_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.text.format.Formatter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Environment;
import android.widget.Toast;

import com.example.filemanagerprj.FileAdapter;
import com.example.filemanagerprj.FileOpener;
import com.example.filemanagerprj.MainActivity;
import com.example.filemanagerprj.OnFileSelectedListener;
import com.example.filemanagerprj.R;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class CardFragment extends Fragment implements OnFileSelectedListener {
    //    private RecyclerView recyclerView2;
    private List<File> fileList2;
    private ImageView imgBack2;
    private TextView tvPathHolder2;
    //    File storageExt;
    View view2;
    RecyclerView recyclerView;
    String pathToSD = "";
    private FileAdapter fileAdapter2;
    String data;
    File[] mmm;
    File pathSd;

    String[] sdItems = {"Details", "Rename", "Delete"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view2 = inflater.inflate(R.layout.fragment_card, container, false);
        imgBack2 = view2.findViewById(R.id.image_back2);
        tvPathHolder2 = view2.findViewById(R.id.tv_path_holder2);

        // получаем доступ к SD
//        String externalStorage = Environment.getExternalStorageDirectory().getAbsolutePath();
//        File mmm = Environment.getExternalStorageDirectory();
//        String externalStorage = Environment.getExternalStorageDirectory().toString();
//        File[] mmm = ContextCompat.getExternalFilesDirs(this);
        mmm = ContextCompat.getExternalFilesDirs(requireContext(), null);
//        File mmm = ContextCompat.getExternalFilesDirs(requireContext(), null)[1];
        if (mmm.length > 1 && mmm[1] != null) {
//            pathSd = mmm[1];

            String sss = mmm[1].getPath();
            String[] path = sss.split("/");

            if (path.length >= 3) {
                pathToSD = path[0] + "/" + path[1] + "/" + path[2];
//            tvPathHolder2.setText("Path SD: " + pathToSD);
                pathSd = new File(pathToSD);
                if (getArguments() != null) { // это что такое???
                    data = getArguments().getString("path");
                    pathSd = new File(data);
                }
                tvPathHolder2.setText("Path SD: " + pathSd.getAbsolutePath());
                runtimePermission();  // ечли карты нет то нет смысла отображать списки
            } else {
                tvPathHolder2.setText("Path SD: " + "SD card ejected...");
            }
        } else {
            tvPathHolder2.setText("Path(1) SD: " + "SD card ejected...");
        }

        return view2;
    }

    private void runtimePermission() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                displayFiles();
            }
        }
        //
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                try {
                    Uri uri = Uri.fromParts("package", getActivity().getPackageName(), null);
                    Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    intent.setData(uri);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.setData(Uri.parse(String.format("package:%s", getActivity().getPackageName())));
                    getActivity().startActivityIfNeeded(intent, 101);
                } catch (Exception e) {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                    getActivity().startActivityIfNeeded(intent, 101);
                }

            }
            if (Environment.isExternalStorageManager()) {
                displayFiles();
            }
        }

    }


    private ArrayList<File> findFiles(File file) {
        ArrayList<File> arrayList = new ArrayList<>();
        File[] files = file.listFiles();
        for (File singleFile : files) {
            if (singleFile.isDirectory() && !singleFile.isHidden()) {
                arrayList.add(singleFile);
            }
        }
        for (File singleFile : files) {
            if (singleFile.getName().toLowerCase().endsWith(".jpeg") ||
                    singleFile.getName().toLowerCase().endsWith(".jpg") ||
                    singleFile.getName().toLowerCase().endsWith(".png") ||
                    singleFile.getName().toLowerCase().endsWith(".mp3") ||
                    singleFile.getName().toLowerCase().endsWith(".wav") ||
                    singleFile.getName().toLowerCase().endsWith(".mp4") ||
                    singleFile.getName().toLowerCase().endsWith(".pdf") ||
                    singleFile.getName().toLowerCase().endsWith(".doc") ||
                    singleFile.getName().toLowerCase().endsWith(".apk")) {
                arrayList.add(singleFile);
            }
        }
        return arrayList;
    }

    private void displayFiles() {
        recyclerView = view2.findViewById(R.id.recycler_internal2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        fileList2 = new ArrayList<>();
        fileList2.addAll(findFiles(pathSd));

        fileAdapter2 = new FileAdapter(getContext(), fileList2, this);
        recyclerView.setAdapter(fileAdapter2);
    }


    @Override
    public void onFileClicked(File file) {
        if (file.isDirectory()) {
            Bundle bundle = new Bundle();
            bundle.putString("path", file.getAbsolutePath());
            CardFragment cardFragment = new CardFragment();
            cardFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, cardFragment).addToBackStack(null).commit();
        } else {
            FileOpener.openFile(getContext(), file);
        }

    }

    @Override
    public void onFileLongClocked(File file, int position) {
        final Dialog optionDialog = new Dialog(getContext());
        optionDialog.setContentView(R.layout.option_dialog);
        optionDialog.setTitle("Select Options.");
        ListView options = optionDialog.findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter();
        options.setAdapter(customAdapter);
        optionDialog.show();

        options.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sectedItem = parent.getItemAtPosition(position).toString();
                switch (sectedItem) {
                    case "Details":
                        AlertDialog.Builder detailDialog = new AlertDialog.Builder(getContext());
                        detailDialog.setTitle("Details:");
                        final TextView details = new TextView(getContext());
                        detailDialog.setView(details);
                        Date lastModified = new Date(file.lastModified());
                        SimpleDateFormat formatted = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String formattedDate = formatted.format(lastModified);

                        details.setText("File name: " + file.getName() + "\n" + "Size: " + Formatter.formatShortFileSize(getContext(), file.length()) + "\n" + "Path: " + file.getAbsolutePath() + "\n" + "Last modified: " + formattedDate);
                        details.setPadding(70, 10, 10, 10);
                        detailDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.cancel();
                            }
                        });

                        AlertDialog alertDialogDetalis = detailDialog.create();
                        alertDialogDetalis.show();
                        break;
                    case "Rename":
//                        AlertDialog.Builder renameDialog = new AlertDialog.Builder((getContext()));
//                        renameDialog.setTitle("Rename file:");
//                        final EditText name = new EditText(getContext());
//                        renameDialog.setView(name);
//                        renameDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                if (!file.isDirectory()) {
//                                    String newName = name.getEditableText().toString();
//                                    String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("."));
//                                    File current = new File(file.getAbsolutePath());
//                                    File destination = new File(file.getAbsolutePath().replace(file.getName(), newName) + extension);
//                                    if (current.renameTo(destination)) {
//                                        fileList2.set(position, destination);
//                                        fileAdapter2.notifyItemChanged(position);
//                                        Toast.makeText(getContext(), "Renamed!", Toast.LENGTH_SHORT).show();
//                                        displayFiles();
//                                    } else {
//                                        Toast.makeText(getContext(), "Rename not complete!!!", Toast.LENGTH_SHORT).show();
//                                    }
//                                } else {
//                                    String newName = name.getEditableText().toString();
//                                    File current = new File(file.getAbsolutePath());
//                                    File destination = new File(file.getAbsolutePath().replace(file.getName(), newName));
//                                    if (current.renameTo(destination)) {
//                                        fileList2.set(position, destination);
//                                        fileAdapter2.notifyItemChanged(position);
//                                        Toast.makeText(getContext(), "Filder Renamed!", Toast.LENGTH_SHORT).show();
//                                        displayFiles();
//                                    } else {
//                                        Toast.makeText(getContext(), "Folder Rename not complete!!!", Toast.LENGTH_SHORT).show();
//                                    }
//                                }
//
//                            }
//                        });
//
//                        renameDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                optionDialog.cancel();
//                            }
//                        });
//
//                        AlertDialog alertDialogRename = renameDialog.create();
//                        alertDialogRename.show();;
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q) {
                            AlertDialog.Builder renameDialog = new AlertDialog.Builder(getContext());// renameDialog просто название
                            renameDialog.setTitle("Rename File:"); // в renameDialog устанваливаем текст (Title - внимательно, не setText!)
                            final EditText name = new EditText(getContext()); // создаем редактируемый текст в переменной name
                            renameDialog.setView(name); // обращаемся к renameDialog через метод setView и передаем в него значение name

//Кнопки для Ok для Rename и Cancel
// добавляем кнопку Ок с обработчиком нажатия на нее
                            renameDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // Шаг 1: Получаем новое имя от пользователя
                                    String newName = name.getEditableText().toString().trim();
                                    File parentDir = file.getParentFile(); // Получаем папку, в которой лежит переименовываемый файл/папка.

                                    String extension = ""; //Создаём пустую строку extension, куда позже (возможно) запишем расширение. Если файл окажется папкой, или у него нет точки в имени — extension так и останется пустым (""), потому что у папок и некоторых файлов нет расширений.
                                    if (file.isFile()) { // Проверяем, является ли file обычным файлом, а не папкой: file.isFile() вернёт true, если это именно файл и false, если это папка
                                        int dotIndex = file.getName().lastIndexOf("."); //Находим индекс последней точки в имени (обычно перед расширением).
                                        if (dotIndex != -1) { //Если lastIndexOf(".") не находит точку, он вернёт -1. В таком случае расширения нет — значит, не трогаем extension.
                                            extension = file.getName().substring(dotIndex); // Получаем подстроку от точки до конца — то есть само расширение вместе с точкой!
                                            //Итого, что делает этот блок? Если это файл, а не папка: Ищем, есть ли расширение (точка в имени). Если есть — берём его и сохраняем. Если файл без расширения или это папка — extension остаётся пустым.
                                        }
                                    }

                                    File destination = new File(parentDir, newName + extension); //Создаём новый путь — куда хотим переименовать: В ту же папку (parentDir) С новым именем (newName) Плюс расширение (если файл).

                                    if (file.renameTo(destination)) { //Пробуем переименовать файл или папку: renameTo(...) возвращает true, если всё прошло успешно.
//+++++++++++++++++++++++++++этот блок убрал и заработало переименование как папки и файла в корне так и файла в папке+++++++++++++++++++++++++++++++++++
//                                    fileList.set(position, destination); //Обновляем элемент в списке fileList на новое значение.
//                                    fileAdapter.notifyItemChanged(position); //Сообщаем адаптеру, что элемент на этой позиции изменился (notifyItemChanged).
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                                        Toast.makeText(getContext(), "Renamed!", Toast.LENGTH_SHORT).show();
                                        displayFiles();
                                    } else {
                                        Toast.makeText(getContext(), "Rename Error!", Toast.LENGTH_SHORT).show();
                                    }
//  здесь код с урока в нем не работает переименование файлов внутри папок. в корне переименовывает нормально
/*                                String newName = name.getEditableText().toString(); // берём текст из name (это поле ввода из пункта Rename), превращаем его в обычную строку и сохраняешь в newName.
// Создаём объект File, указывающий на текущий файл, который мы хотим переименовать.
                                File current = new File(file.getAbsolutePath()); // переменная для исходного файла который будем переименовывать
                                File destination;
                                if(!file.isDirectory()){
                                // Получаем расширение файла. Здесь от всего пути останется точка и расширение. и сохранится это в extension
                                String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".")); // file.getAbsolutePath() Получает полный путь к файлу в виде строки (например "/storage/emulated/0/Download/image.jpg"). lastIndexOf(".")  Ищет последнюю точку в этом пути. Она как раз перед расширением файла (file.getAbsolutePath().lastIndexOf(".") ➝ позиция точки перед ".jpg"). substring(...) Берёт подстроку от этой точки до конца строки, то есть возвращает (".jpg" - да вместе с точкой!). Что будет в переменной extension? - ".jpg"//Если тебе нужно только расширение без точки, можно сделать вот так: String extension = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf(".") + 1);
                                destination = new File(file.getAbsolutePath().replace(file.getName(), newName) + extension); // Эта строка создаёт новый путь для файла, заменяя старое имя файла на новое, и добавляя расширение. file.getAbsolutePath() - получаем полный путью file.getName() - Получаем только имя файла (без пути). .replace(file.getName(), newName) - заменяем исходное имя на новое. + extension - добавляем расширение. Все это сохраняем в destination
                                }
                                else {
                                    destination = new File(file.getAbsolutePath().replace(file.getName(), newName));
                                }
                                 if (current.renameTo(destination)){// если текущий файл или папка (в current попадает и то и другое) имеет расширение
                                    fileList.set(position, destination); // Обновляем список файлов (fileList) — заменяем старый файл на новый по позиции position
                                    fileAdapter.notifyItemChanged(position); // Сообщаем адаптеру  что на позиции position что-то изменилось.
                                    Toast.makeText(getContext(), "Renamed!", Toast.LENGTH_SHORT).show(); // сообщение "Renamed!" — подтверждение успешного действия. getContext() означает что это сообщение появится в этом окне
                                     displayFiles(); // сразу обновляем экран чтобы переименованный файл увидеть
                                }
                                else {
                                    Toast.makeText(getContext(), "Renamed Error!", Toast.LENGTH_SHORT).show(); // если переименование не удалось — выводим сообщение об ошибке.
// Что делает весь блок? Когда пользователь жмёт "ОК" в диалоге переименования: //Читает новый текст, который он ввёл.//Выделяет расширение исходного файла.//Создаёт новый путь с новым именем и тем же расширением.
//Пытается переименовать файл.//Если успешно://Обновляет список файлов.//Обновляет UI.//Показывает тост "Renamed!".//Если неуспешно://Показывает "Renamed Error!"
                            }*/
                                }
                            });
                            // добавляем кнопку Cancel с обработчиком нажатия на нее
                            renameDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    optionDialog.cancel(); // жмем Cancel и окно Rename закрывается
                                }
                            });
                            AlertDialog alertDialogRenaime = renameDialog.create(); //вызываем AlertDialog. это для Renaim
                            alertDialogRenaime.show();

                        } else {
                            Toast.makeText(getContext(), "Sorry, you version Android too old... Please Upgrade...", Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case "Delete":
                        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q) {
                        AlertDialog.Builder deleteDialog = new AlertDialog.Builder(getContext());
                        deleteDialog.setTitle("Delete " + file.getName() + " ?!");
                        deleteDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                file.delete();
                                displayFiles();
//                           fileList.remove(position);
//                           fileList.clear();
//                           fileList.addAll(findFiles(storage));
//                           fileAdapter2.notifyDataSetChanged();
                                Toast.makeText(getContext(), "Deleted file..." + file.getName(), Toast.LENGTH_SHORT).show();

                            }
                        });

                        deleteDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                optionDialog.cancel();
                            }
                        });
                        AlertDialog alertDialogDelete = deleteDialog.create();
                        alertDialogDelete.show();
                    } else {
                        Toast.makeText(getContext(), "Sorry, you version Android too old... Please Upgrade...", Toast.LENGTH_SHORT).show();
                    }
                        break;
                }
            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return sdItems.length;
        }

        @Override
        public Object getItem(int position) {
            return sdItems[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint("ViewHolder") View myView = getLayoutInflater().inflate(R.layout.option_layout, null);
            TextView txtOptions = myView.findViewById(R.id.txt_option);
            ImageView imgOptions = myView.findViewById(R.id.img_option);

            txtOptions.setText(sdItems[position]);
            if (sdItems[position].equals("Details")) {
                imgOptions.setImageResource(R.drawable.outline_chat_info_24);
            } else if (sdItems[position].equals("Rename")) {
                imgOptions.setImageResource(R.drawable.rename);
            } else if (sdItems[position].equals("Delete")) {
                imgOptions.setImageResource(R.drawable.delete);
            }

            return myView;
        }
    }


}