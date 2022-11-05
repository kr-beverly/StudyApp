package com.example.myapplication_study;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SignNotice extends Fragment {
    private Button sign_notice_write_btn;
    private View view;

    ListView sign_notice_listView;
    SignNoticeAdapter signNoticeAdapter;
    public static ArrayList<SignNoticeList> signNoticeListArrayList = new ArrayList<>();

    String url = "http://capstudyapp.dothome.co.kr/signBoardList.php";
    SignNoticeList signNoticeList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_signnotice, container, false);

        sign_notice_listView = view.findViewById(R.id.sign_notice_listView);
        signNoticeAdapter = new SignNoticeAdapter(getContext(), signNoticeListArrayList);
        sign_notice_listView.setAdapter(signNoticeAdapter);

        sign_notice_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                startActivity(new Intent(getActivity(),Detail.class).putExtra("position",position));
            }
        });

        retrieveData();

        //글쓰기 창으로 넘어감
        sign_notice_write_btn = view.findViewById(R.id.sign_notice_write_btn);
        sign_notice_write_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Register.class);
                startActivity(intent);
            }
        });

        return view;
    }

//    private void goToSingNoticeDetails(int position) {
//        Intent intent = new Intent(requireContext(), Detail.class);
//        intent.putExtra(Detail.EXTRA_ITEM, (Serializable) signNoticeAdapter.getItem(position));
//        startActivity(intent);
//    }

    public void retrieveData(){
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        signNoticeListArrayList.clear();
                        try{

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(success.equals("1")){
                                for(int i=0;i<jsonArray.length();i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String writ_num = object.getString("writ_num");
                                    String writ_title = object.getString("writ_title");
                                    String writ_content = object.getString("writ_content");
                                    String writ_date = object.getString("writ_date");

                                    signNoticeList = new SignNoticeList(writ_num, writ_title, writ_content, writ_date);
                                    signNoticeListArrayList.add(signNoticeList);
                                    signNoticeAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}

//// 게시물의 댓글을 읽어오는 함수
//class LoadCmt extends AsyncTask<String, Void, String> {
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//
//        Log.d(TAG, "onPreExecute");
//    }
//
//
//    @Override
//    protected void onPostExecute(String result) {
//        super.onPostExecute(result);
//        Log.d(TAG, "onPostExecute, " + result);
//
//        // 댓글을 뿌릴 LinearLayout 자식뷰 모두 제거
//        comment_layout.removeAllViews();
//
//        try {
//
//            // JSONArray, JSONObject 로 받은 데이터 파싱
//            JSONArray jsonArray = null;
//            jsonArray = new JSONArray(result);
//
//            // custom_comment 를 불러오기 위한 객체
//            LayoutInflater layoutInflater = LayoutInflater.from(DetailActivity.this);
//
//            for(int i=0;i<jsonArray.length();i++){
//
//                // custom_comment 의 디자인을 불러와서 사용
//                View customView = layoutInflater.inflate(R.layout.custom_comment, null);
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//
//                String userid= jsonObject.optString("userid");
//                String content = jsonObject.optString("content");
//                String crt_dt = jsonObject.optString("crt_dt");
//
//                ((TextView)customView.findViewById(R.id.cmt_userid_tv)).setText(userid);
//                ((TextView)customView.findViewById(R.id.cmt_content_tv)).setText(content);
//                ((TextView)customView.findViewById(R.id.cmt_date_tv)).setText(crt_dt);
//
//                // 댓글 레이아웃에 custom_comment 의 디자인에 데이터를 담아서 추가
//                comment_layout.addView(customView);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
//    @Override
//    protected String doInBackground(String... params) {
//
//        String board_seq = params[0];
//        String server_url = "http://15.164.252.136/load_cmt.php";
//
//
//        URL url;
//        String response = "";
//        try {
//            url = new URL(server_url);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setReadTimeout(15000);
//            conn.setConnectTimeout(15000);
//            conn.setRequestMethod("POST");
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            Uri.Builder builder = new Uri.Builder()
//                    .appendQueryParameter("board_seq", board_seq);
//            String query = builder.build().getEncodedQuery();
//
//            OutputStream os = conn.getOutputStream();
//            BufferedWriter writer = new BufferedWriter(
//                    new OutputStreamWriter(os, "UTF-8"));
//            writer.write(query);
//            writer.flush();
//            writer.close();
//            os.close();
//
//            conn.connect();
//            int responseCode=conn.getResponseCode();
//
//            if (responseCode == HttpsURLConnection.HTTP_OK) {
//                String line;
//                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                while ((line=br.readLine()) != null) {
//                    response+=line;
//                }
//            }
//            else {
//                response="";
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return response;
//    }
//}
//
//// 댓글을 등록하는 함수
//class RegCmt extends AsyncTask<String, Void, String> {
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//
//        Log.d(TAG, "onPreExecute");
//    }
//
//
//    @Override
//    protected void onPostExecute(String result) {
//        super.onPostExecute(result);
//        Log.d(TAG, "onPostExecute, " + result);
//
//        // 결과값이 성공으로 나오면
//        if(result.equals("success")){
//
//            //댓글 입력창의 글자는 공백으로 만듦
//            comment_et.setText("");
//
//            // 소프트 키보드 숨김처리
//            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            imm.hideSoftInputFromWindow(comment_et.getWindowToken(), 0);
//
//            // 토스트메시지 출력
//            Toast.makeText(getcontext, "댓글이 등록되었습니다.", Toast.LENGTH_SHORT).show();
//
//            // 댓글 불러오는 함수 호출
//            LoadCmt loadCmt = new LoadCmt();
//            loadCmt.execute(board_seq);
//        }else
//        {
//            Toast.makeText(DetailActivity.this, result, Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    @Override
//    protected String doInBackground(String... params) {
//
//        String userid = params[0];
//        String content = params[1];
//        String board_seq = params[2];
//
//        String server_url = "http://15.164.252.136/reg_comment.php";
//
//
//        URL url;
//        String response = "";
//        try {
//            url = new URL(server_url);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setReadTimeout(15000);
//            conn.setConnectTimeout(15000);
//            conn.setRequestMethod("POST");
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            Uri.Builder builder = new Uri.Builder()
//                    .appendQueryParameter("userid", userid)
//                    .appendQueryParameter("content", content)
//                    .appendQueryParameter("board_seq", board_seq);
//            String query = builder.build().getEncodedQuery();
//
//            OutputStream os = conn.getOutputStream();
//            BufferedWriter writer = new BufferedWriter(
//                    new OutputStreamWriter(os, "UTF-8"));
//            writer.write(query);
//            writer.flush();
//            writer.close();
//            os.close();
//
//            conn.connect();
//            int responseCode=conn.getResponseCode();
//
//            if (responseCode == HttpsURLConnection.HTTP_OK) {
//                String line;
//                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                while ((line=br.readLine()) != null) {
//                    response+=line;
//                }
//            }
//            else {
//                response="";
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return response;
//    }
//}