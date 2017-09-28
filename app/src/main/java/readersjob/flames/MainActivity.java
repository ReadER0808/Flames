package readersjob.flames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText first_name = (EditText) findViewById(R.id.editText);
        final EditText second_name = (EditText) findViewById(R.id.editText2);
        ImageButton imageButton =(ImageButton) findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String F_name=first_name.getText().toString();
                String S_name=second_name.getText().toString();
                F_name = F_name.trim();
                S_name = S_name.trim();
                F_name = F_name.toLowerCase();
                S_name = S_name.toLowerCase();
                String name1_split[] = F_name.split(" ");
                String name2_split[] = S_name.split(" ");
                String name1,name2;
                name1="";
                name2="";
                for(int i=0;i<name1_split.length;i++)
                {
                    name1 = name1+name1_split[i];
                }
                for(int i=0;i<name2_split.length;i++)
                {
                    name2 = name2+name2_split[i];
                }
                int length = name1.length()+name2.length();
                boolean name_check[] = new boolean[name2.length()];
                for(int i=0;i<name2.length();i++)
                {
                    name_check[i]=false;
                }
                for(int i=0;i<name1.length();i++)
                {
                    for(int j=0;j<name2.length();j++)
                    {
                        if((name_check[j]==false) && (name1.charAt(i) == name2.charAt(j)))
                        {
                            name_check[j]=true;
                            length = length-2;
                            break;
                        }
                    }
                }
                boolean flames_check[] = new boolean[6];
                for(int i=0;i<6;i++)
                {
                    flames_check[i] = true;
                }
                int count = 6;
                int k=1,deleted_letters=0;
                int j;
                for(j=0;j<=count;j++)
                {
                    if(k <= length)
                    {
                        if(j == count)
                        {
                            j=0;
                        }
                        if(flames_check[j] == true)
                        {
                            k = k+1;
                        }
                    }
                    if((k-1)==length)
                    {
                        deleted_letters = deleted_letters+1;
                        flames_check[j] = false;
                        k = 1;
                    }
                    if(deleted_letters==6)
                    {
                        if(j==0)
                        {
                            Intent myIntent = new Intent(MainActivity.this,FriendActivity.class);
                            startActivity(myIntent);
                        }
                        else if(j==1)
                        {
                            Intent myIntent1 = new Intent(MainActivity.this,LoveActivity.class);
                            startActivity(myIntent1);
                        }
                        else if(j==2)
                        {
                            Intent myIntent2 = new Intent(MainActivity.this,AffectionActivity.class);
                            startActivity(myIntent2);
                        }
                        else if(j==3)
                        {
                            Intent myIntent3 = new Intent(MainActivity.this,MarriageActivity.class);
                            startActivity(myIntent3);
                        }
                        else if(j==4)
                        {
                            Intent myIntent4 = new Intent(MainActivity.this,EnemyActivity.class);
                            startActivity(myIntent4);
                        }
                        else if(j==5)
                        {
                            Intent myIntent5 = new Intent(MainActivity.this,SiblingActivity.class);
                            startActivity(myIntent5);
                        }
                        break;
                    }
                }













            }
        });
    }
}
