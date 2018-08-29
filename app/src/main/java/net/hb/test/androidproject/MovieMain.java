package net.hb.test.androidproject;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MovieMain extends Fragment {
    LinearLayout linear;
    ArrayList<Movie> mv = new ArrayList<Movie>();

    public MovieMain(){ }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.moviemain, container, false);

        ListView listView = v.findViewById(R.id.listView);
        linear = v.findViewById(R.id.linear);

        mv.add(new Movie(R.drawable.a, R.drawable.a15, "미션 임파서블: 폴아웃", "전 세계 최강의 스파이 기관 IMF의 최고 요원 에단 헌트(톰 크루즈)와 그의 팀은 테러조직의 핵무기 소지를 막기 위해 미션에 착수한다. \n" +
                " 에단 헌트는 작전 수행 중 예상치 못한 결단을 내리게 되고, 중앙정보국 CIA는 그를 견제하기 위해 상급 요원 어거스트 워커(헨리 카빌)를 파견한다. \n" +
                " 최악의 테러 위기와 라이벌의 출현 속, 팀이 행한 모든 선의의 선택들이 최악의 결과로 돌아오면서 미션은 점점 더 예측할 수 없는 상황으로 치닫게 되는데… ", true, "2018.07.25"));
        mv.add(new Movie(R.drawable.b, R.drawable.aa, "너의 결혼식", "기억하나요? 당신의 첫사랑\n" +
                "고3 여름, 전학생 ‘승희’(박보영)를 보고 첫눈에 반한 ‘우연’(김영광). \n" +
                " 승희를 졸졸 쫓아다닌 끝에 마침내 공식커플로 거듭나려던 그때! \n", false, "2018.08.22"));
        mv.add(new Movie(R.drawable.c, R.drawable.aa, "신과함께: 인과 연", "천 년 동안 48명의 망자를 환생시킨 저승 삼차사, 한 명만 더 환생시키면 그들도 새로운 삶을 얻을 수 있다. \n" +
                " 하지만 강림(하정우)은 원귀였던 수홍(김동욱)을 자신들의 마지막 귀인으로 정하는 이해할 수 없는 선택을 한다. \n", true, "2018.08.01"));
        mv.add(new Movie(R.drawable.d, R.drawable.aall, "인크레더블2", "지금까지의 히어로는 잊어라!\n" +
                "슈퍼맘 ‘헬렌’이 국민 히어로 ‘일라스티걸’로 활약하며 세상의 주목을 받자 \n" +
                " 바쁜 아내의 몫까지 집안일을 하기 위해 육아휴직을 낸 아빠 ‘밥’은 ", true, "2018.07.18"));
        mv.add(new Movie(R.drawable.e, R.drawable.a15, "더 스퀘어", "뭘 해도 더-럽게 안 풀리는 이 남자,\n" +
                "당신의 도움이 필요하다!\n" +
                "‘더 스퀘어’라는 새로운 전시를 앞둔", true, "2018.08.02"));
        mv.add(new Movie(R.drawable.f, R.drawable.a12, "맘마미아!2", "전세계가 사랑한 최고의 뮤지컬 영화가 돌아온다!\n" +
                "“인생은 짧고 세상은 넓어. 멋진 추억을 만들고 싶어!”\n", false, "2018.08.08"));

        MovieAdapter adapter = new MovieAdapter(getContext(), R.layout.movie, mv);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                View detail2 = View.inflate(parent.getContext(), R.layout.detail, null);
                ImageView imageView = detail2.findViewById(R.id.imageView);
                TextView dttitle = detail2.findViewById(R.id.dttitle);
                TextView mvstory = detail2.findViewById(R.id.mvstory);

                imageView.setImageResource(mv.get(position).img1);
                dttitle.setText(mv.get(position).title);

                String str = mv.get(position).story;
                if (str.length() > 15) {
                    str = str.substring(0, 20);
                    str = str + "...";
                }
                mvstory.setText(str);


                AlertDialog.Builder ab = new AlertDialog.Builder(parent.getContext());
                ab.setView(detail2);
                ab.setNegativeButton("close", null);
                ab.show();
            }
        });

        return v;
    }

}
