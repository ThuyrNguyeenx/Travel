package com.example.thuynguyen.test1.control;

import android.util.Log;

import com.example.thuynguyen.test1.model.UserAccount;
import com.example.thuynguyen.test1.view.LoginActivity;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ThuyNguyen on 17/04/2017.
 */

public class Login {

    public static Firebase myFirebase = new Firebase("https://loginaccount-522f1.firebaseio.com/");
    private static LoginActivity loginActivity;
    public static ArrayList<UserAccount> listAC = new ArrayList<>();
    public static void Register(UserAccount user){

        myFirebase.child("UserAcount").push().setValue(user);
    }
    public static void getAccount(){

        myFirebase.child("UserAcount").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterator in = dataSnapshot.getChildren().iterator();
                while (in.hasNext()){
                    Iterator inChildren = ((DataSnapshot)in.next()).getChildren().iterator();
                    while (inChildren.hasNext()){
                        String user = String.valueOf((DataSnapshot)inChildren.next());
                        String pass = String.valueOf((DataSnapshot)inChildren.next());
                        setList(new UserAccount(user,pass));
                    }
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
    public static void setList(UserAccount userAccount){
        listAC.add(userAccount);
    }
}
