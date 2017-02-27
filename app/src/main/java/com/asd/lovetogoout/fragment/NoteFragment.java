package com.asd.lovetogoout.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

//import android.app.Fragment;

public class NoteFragment extends Fragment {
	public static Bitmap bitmap;
	public static Bitmap bitmap2;

	private View view;
	private int currentPage;
	/*private PullToRefreshListView lv_notes_list;
	private List<Integer> icons;
	private RequestQueue rq;
	private boolean isRefreshing;
	private NoteListAdapter1 adapter;*/
	private int U_ID;
	private int uCollect;

	public int getuCollect() {
		return uCollect;
	}

	public void setuCollect(int uCollect) {
		this.uCollect = uCollect;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/*if (view == null) {
			view = inflater.inflate(R.layout.fragment_note, container, false);
		}

		lv_notes_list = (PullToRefreshListView) view.findViewById(R.id.lv_notes_list);
		lv_notes_list.setMode(Mode.BOTH);
		icons = new ArrayList<Integer>();

		rq = Volley.newRequestQueue(getActivity());

		icons.add(R.drawable.note3);
		adapter = new NoteListAdapter1(getActivity());
		// LayoutInflater.from(getActivity())
		View v = inflater.inflate(R.layout.activity_viewpage, null);
		lv_notes_list.getRefreshableView().addHeaderView(v);

		currentPage = 1;

		SharedPreferences pre = getActivity().getSharedPreferences("Userinfo", 0);
		U_ID = pre.getInt("u_id", 0);

		VolleyNetRequest.noteArrayjsonRequest(getActivity(), lv_notes_list, rq,
				"http://10.202.1.48:8080/LoveToGoOut/NotesJsonservlet3", adapter, currentPage, U_ID);

		lv_notes_list.setOnRefreshListener(new OnRefreshListener<ListView>() {

			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				// TODO Auto-generated method stub
				String label = DateUtils.formatDateTime(getActivity(), System.currentTimeMillis(),
						DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

				refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

				// Do work to refresh the list here.
				new GetDataTask().execute();

			}
		});
*/
		return view;

	}

/*	class GetDataTask extends AsyncTask<Void, Void, String> {

		// 后台处理部分
		@Override
		protected String doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			String str = "Added after refresh...I add";
			return str;
		}

		// 这里是对刷新的响应，可以利用addFirst（）和addLast()函数将新加的内容加到LISTView中
		// 根据AsyncTask的原理，onPostExecute里的result的值就是doInBackground()的返回值
		protected void onPostExecute(String result) {
			if (lv_notes_list.isHeaderDown()) {
				VolleyNetRequest.noteArrayjsonRequest(getActivity(), lv_notes_list, rq,
						"http://10.202.1.48:8080/LoveToGoOut/NotesJsonservlet3", adapter, 1, U_ID);
			} else if (lv_notes_list.isFooterDown()) {
				currentPage = currentPage + 1;
				VolleyNetRequest.noteArrayjsonRequest1(getActivity(), lv_notes_list, rq,
						"http://10.202.1.48:8080/LoveToGoOut/NotesJsonservlet3", adapter, currentPage, U_ID);
				// Call onRefreshComplete when the list has been refreshed.
			}
			lv_notes_list.onRefreshComplete();

			super.onPostExecute(result);
		}
	}*/

	public String Landserver() {
		InputStream is = null;
		HttpURLConnection conn = null;
		try {
			URL url = new URL("http://10.202.1.48:8080/LoveToGoOut/TestServlet");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5 * 1000);
			is = conn.getInputStream();
			byte[] b = new byte[1000];
			int len;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((len = is.read()) > 0) {
				baos.write(b, 0, len);
			}
			String json = new String(baos.toByteArray(), "utf-8");
			return json;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/*private void checkNetWorkInfo() {
		if (!Tools.isNetworkAvailable(getContext())) {
			new AlertDialog.Builder(getContext()).setTitle("提示!").setIcon(android.R.drawable.ic_dialog_info)
					.setMessage("检测到你还没开启网络，请开启").setNegativeButton("取消", null)
					.setPositiveButton("开启", new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));// 进入无线网络配置界面
							startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS)); // 进入手机中的wifi网络设置界面
						}
					}).show();
		}
	}*/

	/*public class NoteListAdapter1 extends BaseAdapter {
		private List<Integer> icons;
		private List<NotesJson> data;
		private Context context;
		private LayoutInflater inflater;
		private CaoImageCache imageCache;
		private CaoImageCache myImageCache;

		public List<NotesJson> getData() {
			return data;
		}

		public void setData(List<NotesJson> data) {
			this.data = data;
		}

	
		public NoteListAdapter1(List<NotesJson> data,Context context) {
			// TODO Auto-generated constructor stub
			this.data = data;
			this.context = context;
			if (imageCache == null) {
				imageCache = new CaoImageCache();
			}
			if (myImageCache == null) {
				myImageCache = new CaoImageCache();
			}
			if (inflater == null) {
				inflater = getActivity().getLayoutInflater();
			}
		}

		public NoteListAdapter1(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
			if (imageCache == null) {
				imageCache = new CaoImageCache();
			}
			if (myImageCache == null) {
				myImageCache = new CaoImageCache();
			}
			if (inflater == null) {
				inflater = getActivity().getLayoutInflater();
			}
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return data.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_notes, null);
				holder = new ViewHolder();
				holder.tv_notes_title = (TextView) convertView.findViewById(R.id.tv_notes_title);
				holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
				holder.img_icon = (CircleImageView) convertView.findViewById(R.id.img_icon);
				holder.img_background_note = (ImageView) convertView.findViewById(R.id.img_background_note);

				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			final NotesJson notesJson = data.get(position);
			convertView.setClickable(true);
			final int pos = position;
			convertView.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setClass(getContext(), TravelNoteActivity.class);
					Bundle data = new Bundle();
					int nId = notesJson.getNj_Id();
					Toast.makeText(getActivity(), String.valueOf(nId), Toast.LENGTH_SHORT).show();
					String igUrl = "http://10.202.1.48:8080/LoveToGoOut/" + notesJson.getNj_photo();
					data.putInt("nId", nId);
					data.putString("nST", notesJson.getNj_startTime());
					data.putString("nTt", notesJson.getNj_Name());
					uCollect = notesJson.getuCollect();
					data.putInt("uCollect", uCollect);
					Log.e("tns", "collect " + uCollect);
					data.putInt("writerId", notesJson.getWriterId());
					Log.e("tns", "writer"+notesJson.getWriterId());
					data.putInt("pos", pos);

					Log.e("tns", nId + " like ? " + notesJson.getuCollect());
					Log.e("tns", "n title: " + notesJson.getNj_Name());
					bitmap = imageCache.getBmap(igUrl);

					if (bitmap == null) {
						Log.e("tns", "notebitmap null");
						data.putString("imgurl", igUrl);
					}

					bitmap2 = myImageCache.getBmap("http://10.202.1.48:8080/LoveToGoOut/" + notesJson.getNj_icon());
					if (bitmap2 == null) {
						Log.e("tns", "notebitmappic null");
						System.out.println(notesJson.getNj_icon());
						Log.e("tns", notesJson.getNj_icon());
						data.putString("UPic", "http://10.202.1.48:8080/LoveToGoOut/" + notesJson.getNj_icon());
					}
					*//*
					 * imageCache.removeImageCache();
					 * myImageCache.removeImageCache();
					 *//*
					data.putString("ntitle", notesJson.getNj_Name());
					intent.putExtras(data);
					startActivity(intent);
				}
			});

			// img_background_note.setImageResource(R.drawable.note1);
			// img_icon.setImageResource(icons.get(position));

			holder.tv_notes_title.setText(notesJson.getNj_Name());
			holder.tv_date.setText(notesJson.getNj_startTime());
			// imageCache=new MyImageCache();
			BitmapUtils bitmapUtils=new BitmapUtils(context);
			bitmapUtils.display(holder.img_background_note, " http://10.202.1.48:8080/LoveToGoOut/" + notesJson.getNj_photo());
//			ImageLoader imageLoader = new ImageLoader(rq, imageCache);
//
//			// readBitmapViaVolley(imgurl, holder.img_icon);
//			// imageCache=new MyImageCache();
//
//			holder.img_background_note.setDefaultImageResId(R.drawable.jiazai);
//			holder.img_background_note.setErrorImageResId(R.drawable.jiazai_default);
//			holder.img_background_note.setImageUrl(" http://10.202.1.48:8080/LoveToGoOut/" + notesJson.getNj_photo(),
//					imageLoader);
//			BitmapUtils bitmapUtils1=new BitmapUtils(context);
			String imgurl = " http://10.202.1.48:8080/LoveToGoOut/" + notesJson.getNj_icon();
//			bitmapUtils1.display(holder.img_icon, imgurl);
//			// UrlTOBitmap uBitmap = new UrlTOBitmap(holder.img_icon);
//			// uBitmap.execute(imgurl);
//
//			ImageLoader imageLoader2 = new ImageLoader(rq, myImageCache);
//			@SuppressWarnings("static-access")
//			ImageListener listener = imageLoader2.getImageListener(holder.img_icon, R.drawable.default_head,
//					R.drawable.empty);
//			imageLoader2.get(imgurl, listener);

			// holder.img_icon.setImageBitmap(bitmap2);

			return convertView;
		}
	}

	public final class ViewHolder {

		public ImageView img_background_note;
		public CircleImageView img_icon;
		public TextView tv_date;
		public TextView tv_notes_title;

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("tns", "onStart()");
		if (userCollect1 != -1) {
			NotesJson nJson = adapter.getData().get(position1);
			nJson.setuCollect(userCollect1);
		}

	}*/

	public static void setUserCollect(int userCollect, int position) {
		Log.e("tns", position + "......" + userCollect);
		userCollect1 = userCollect;
		position1 = position;

	}

	public static int userCollect1 = -1;
	public static int position1;

}
