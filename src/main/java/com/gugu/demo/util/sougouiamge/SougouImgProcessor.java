package com.gugu.demo.util.sougouiamge;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 下载搜狗图库
 * 设置URL请求参数
 * 访问URL请求，获取图片地址
 * 图片地址存入List
 * 遍历List，使用线程池下载到本地
 */
public class SougouImgProcessor {
    private String url;
    private SougouImgPipeline pipeline;
    private List<JSONObject> dataList;
    private List<String> urlList;
    private String word;

    public SougouImgProcessor(String url, String word) {
        this.url = url;
        this.word = word;
        this.pipeline = new SougouImgPipeline();
        this.dataList = new ArrayList<>();
        this.urlList = new ArrayList<>();
    }

    public void process(int idx, int size) {
        String res = HttpClientUtils.get(String.format(this.url, idx, size, this.word));
        JSONObject object = JSONObject.parseObject(res);
        List<JSONObject> items = (List<JSONObject>) ((JSONObject) object.get("data")).get("items");
        for (JSONObject item : items) {
            this.urlList.add(item.getString("picUrl"));
        }
        this.dataList.addAll(items);
    }

    // 下载
    public void pipelineData() {
        // 多线程
        pipeline.processSync2(this.urlList, this.word, 20);
    }

    public static void main(String[] args) {
        String url = "https://pic.sogou.com/napi/pc/searchList?mode=1&start=%s&xml_len=%s&query=%s";
        SougouImgProcessor processor = new SougouImgProcessor(url, "美女");

        int start = 0, size = 50, limit = 100; // 定义爬取开始索引、每次爬取数量、总共爬取数量

        for (int i = start; i < start + limit; i += size)
            processor.process(i, size);

        processor.pipelineData();

    }
}
