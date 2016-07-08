package il.ac.shenkar.showshenkar.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import il.ac.shenkar.showshenkar.R;
import il.ac.shenkar.showshenkar.adapters.ProjectGalleryRecyclerAdapter;
import il.ac.shenkar.showshenkar.backend.contentApi.ContentApi;
import il.ac.shenkar.showshenkar.backend.contentApi.model.Content;
import il.ac.shenkar.showshenkar.backend.contentApi.model.Info;
import il.ac.shenkar.showshenkar.backend.contentApi.model.Media;
import il.ac.shenkar.showshenkar.backend.projectApi.ProjectApi;
import il.ac.shenkar.showshenkar.backend.projectApi.model.Project;
import il.ac.shenkar.showshenkar.model.DBHelper;
import il.ac.shenkar.showshenkar.utils.Constants;

public class ProjectActivity extends ShenkarActivity {

    final Context context = this;
    private ProjectGalleryRecyclerAdapter adapter;
    private List<Media> mProjectTumbs;
    private DBHelper dbhelper;
    private   ContentApi contentApi;
    private  Content content;
    private ProjectApi projectApi;
    private Project projectM;
    private List<Media> listM;
    private String urlVideo="none";
    private String urlAudio="none";
    private String idContent;
    static class ProjectViewHolder {
        TextView txtProjectName;
        TextView txtStudentName;
        TextView txtLocation;
        TextView txtProjectDesc;
        ImageView imgScreenShot;

        public ProjectViewHolder(Activity activity) {
            txtProjectName = (TextView) activity.findViewById(R.id.txtProjectName);
            txtStudentName = (TextView) activity.findViewById(R.id.txtStudentName);
            txtLocation = (TextView) activity.findViewById(R.id.txtLocation);
            txtProjectDesc = (TextView) activity.findViewById(R.id.txtProjectDesc);
            imgScreenShot = (ImageView) activity.findViewById(R.id.imgScreenShot);
        }
    }


    //Button playVd;
   // Button playSD;
    private ImageButton playVd ;
    private ImageButton playSD ;
    private MediaPlayer mediaPlayer;
    private ProjectViewHolder views;
    private String project;
    private Long projectId;
    private Project mProject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        // initialize all the project's views
        views = new ProjectViewHolder(this);

        project = getIntent().getStringExtra("project");
        views.txtProjectName.setText(project);
        String students = getIntent().getStringExtra("students");
        views.txtStudentName.setText(students);

        projectId = getIntent().getLongExtra("id", 0);
        playVd = (ImageButton) findViewById(R.id.imageButtonVideo);
        playSD = (ImageButton) findViewById(R.id.imageButtonSound);

        // Initialize recycler view
        RecyclerView rvProjects = (RecyclerView) findViewById(R.id.project_tumbs);
        rvProjects.setLayoutManager(new LinearLayoutManager(this));

        mProjectTumbs = new ArrayList<>();

        Media temp = new Media();
        temp.setUrl("http://lh3.googleusercontent.com/alNfn7CNCfSgaTGXb6T06AnXiwGFi18a_eepmFPKnxhf73QXu7CqVQU0ODKOIYsAzBPx86lE0mJDLyXbciIcFplR");

        mProjectTumbs.add(temp);
        mProjectTumbs.add(temp);
        mProjectTumbs.add(temp);
        mProjectTumbs.add(temp);
        mProjectTumbs.add(temp);
        mProjectTumbs.add(temp);

        adapter = new ProjectGalleryRecyclerAdapter(this, views.imgScreenShot, mProjectTumbs);
        rvProjects.setAdapter(adapter);

        mediaPlayer = new MediaPlayer();
       // playVd = (Button) findViewById(R.id.buttonVideo);
      //  playSD = (Button) findViewById(R.id.buttonSoundM);

        dbhelper=new DBHelper();
        projectApi=dbhelper.getProjectApi();

        new AsyncTask<Void, Void, Project>() {
            @Override
            protected Project doInBackground(Void... params) {
                try {
                    projectM=projectApi.getProject(projectId).execute();
                    idContent=projectM.getContentId();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return projectM;
            }
        }.execute();

        contentApi=dbhelper.getContentApi();
        new AsyncTask<Void, Void, Content>() {
            @Override
            protected Content doInBackground(Void... params) {
                try {
                    content=contentApi.getContent(Long.valueOf(idContent)).execute();
                    listM=content.getMedia();
                    for(int i=0;i<listM.size();i++)
                    {
                        if(listM.get(i).getType()=="video")
                        {
                            urlVideo=listM.get(i).getUrl();
                        }
                        if(listM.get(i).getType()=="audio")
                        {
                            urlAudio=listM.get(i).getUrl();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return content;
            }
        }.execute();

        playVd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlVideo != "none") {
                    Intent i = new Intent(ProjectActivity.this, YouTubeActivity.class);
                    i.putExtra("url", urlVideo );
                    startActivity(i);
                }
                if (urlVideo== "none")
                {
                    Toast.makeText(ProjectActivity.this, "אין וידאו לפרוייקט",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        playSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (urlAudio != "none") {
                    final Dialog dialogT = new Dialog(context);
                    dialogT.setContentView(R.layout.custom);
                    ImageButton dialogButtonPlay = (ImageButton) dialogT.findViewById(R.id.imageButtonPlay);
                    // if button is clicked, close the custom dialog
                    dialogButtonPlay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //  String url = "http://programmerguru.com/android-tutorial/wp-content/uploads/2013/04/hosannatelugu.mp3";
                            String url =urlAudio;
                            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            try {
                                mediaPlayer.setDataSource(url);
                            } catch (IllegalArgumentException e) {

                            } catch (SecurityException e) {

                            } catch (IllegalStateException e) {

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                mediaPlayer.prepare();
                            } catch (IllegalStateException e) {

                            } catch (IOException e) {

                            }
                            mediaPlayer.start();
                        }
                    });
                    ImageButton dialogButtonStop = (ImageButton) dialogT.findViewById(R.id.imageButtonStop);
                    // if button is clicked, close the custom dialog
                    dialogButtonStop.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            mediaPlayer.stop();
                        }
                    });

                    dialogT.show();
                }
                if (urlAudio== "none")
                {
                    Toast.makeText(ProjectActivity.this, "אין קטע שמיעה",
                            Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    public void refresh() {
        final ProjectApi projectApi = new ProjectApi.Builder(
                AndroidHttp.newCompatibleTransport(),
                new JacksonFactory(),
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest request) throws IOException {

                    }
                }).setRootUrl(Constants.ROOT_URL).build();


        new AsyncTask<Void, Void, Project>() {
            @Override
            protected Project doInBackground(Void... params) {
                try {
                    return projectApi.getProject(projectId).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Project project) {
                if (project != null) {
                    mProject = project;
                    refreshContent(Long.parseLong(mProject.getContentId()));
                }
            }
        }.execute();
    }

    private void refreshContent(final Long contentId)
    {
        final ContentApi contentApi = new ContentApi.Builder(
                AndroidHttp.newCompatibleTransport(),
                new JacksonFactory(),
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest request) throws IOException {

                    }
                }).setRootUrl(Constants.ROOT_URL).build();

        new AsyncTask<Void, Void, Content>() {
            @Override
            protected Content doInBackground(Void... params) {
                try {
                    return contentApi.getContent(contentId).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Content result) {
                if (result != null) {
                    adapter.refresh(result.getMedia());
                    Info info = result.getInfo();
                    if (info != null) {
                        views.txtProjectDesc.setText(info.getText());
                    }
                }
            }
        }.execute();
    }


    public void shareProject(View v) {

       Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        Uri screenshotUri = Uri.parse("android.resource://il.ac.shenkar.showshenkar.activities/*");
        try {
            InputStream stream = getContentResolver().openInputStream(screenshotUri);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sharingIntent.setType("image/jpeg");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
        startActivity(Intent.createChooser(sharingIntent, "Share image using"));
        // TODO: implement share project
        Toast.makeText(this, "שתף פרויקט", Toast.LENGTH_LONG).show();
        MyRouteActivity.addProjectId(this, projectId);
    }

    public void showLocation(View v) {
        Intent i = new Intent(this, MapActivity.class);
        i.putExtra("objectId", projectId);
        i.putExtra("objectType", "project");
        startActivity(i);
    }
}
