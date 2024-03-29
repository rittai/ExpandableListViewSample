package com.example.expandablelistviewsample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.SimpleExpandableListAdapter;

public class ExpandableListViewSample extends Activity {
	  private static final String KEY1 = "GROUP";
	  private static final String KEY2 = "CHILD";

	  // 表示させる文字列
	  private String[] GROUPS = {"Group1", "Group2", "Group3"};
	  private String[][][] CHILDREN = {
	      {{"Child11", "Text11"}},
	      {{"Child21", "Text21"}, {"Child22", "Text22"}},
	      {{"Child31", "Text31"}, {"Child32", "Text32"}, {"Child33", "Text33"}},
	  };

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.expandablelistview_sample);

	    // 設定する文字列のリスト
	    List<Map<String, String>> groupData =
	        new ArrayList<Map<String, String>>();
	    List<List<Map<String, String>>> childData =
	        new ArrayList<List<Map<String, String>>>();

	    // リストに文字列を設定していく
	    for (int i = 0; i < GROUPS.length; i++) {
	      // 親要素の追加
	      Map<String, String> curGroupMap =
	          new HashMap<String, String>();
	      groupData.add(curGroupMap);
	      curGroupMap.put(KEY1, GROUPS[i]);
	      curGroupMap.put(KEY2, "");

	      List<Map<String, String>> children =
	          new ArrayList<Map<String, String>>();
	      if (CHILDREN.length > i) {
	        for (int j = 0; j < CHILDREN[i].length; j++) {
	          // 子要素の追加
	          Map<String, String> curChildMap =
	              new HashMap<String, String>();
	          children.add(curChildMap);
	          curChildMap.put(KEY1, CHILDREN[i][j][0]);
	          curChildMap.put(KEY2, CHILDREN[i][j][1]);
	        }
	      }
	      childData.add(children);
	    }

	    // ExpandbleListAdapter の作成
	    ExpandableListAdapter adapter =
	        new SimpleExpandableListAdapter(
	            this,
	            groupData,
	            android.R.layout.simple_expandable_list_item_1,
	            new String[] { KEY1, KEY2 },
	            new int[] { android.R.id.text1, android.R.id.text2 },
	            childData,
	            android.R.layout.simple_expandable_list_item_2,
	            new String[] { KEY1, KEY2 },
	            new int[] { android.R.id.text1, android.R.id.text2 }
	        );

	    ExpandableListView listView =
	      (ExpandableListView) findViewById(R.id.ExpandableListView);
	    // Adapter を設定
	    listView.setAdapter(adapter);

	    // グループがクリックされた時に呼び出されるコールバックを登録
	    listView.setOnGroupClickListener(new OnGroupClickListener() {
	      @Override
	      public boolean onGroupClick(ExpandableListView parent,
	          View v, int groupPosition, long id) {
	        // クリックされた時の処理
	        return false;
	      }
	    });

	    // グループ内の項目がクリックされた時に呼び出されるコールバックを登録
	    listView.setOnChildClickListener(new OnChildClickListener() {
	      @Override
	      public boolean onChildClick(ExpandableListView parent, View v,
	          int groupPosition, int childPosition, long id) {
	        // クリックされた時の処理
	        return false;
	      }
	    });
	  }
	}
