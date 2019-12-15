package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.service.ImageService;
import com.scs.web.space.api.util.Result;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wf
 * @ClassName ImageServiceImage
 * @Description TODO
 * @Date 2019/12/4
 */
@Service
public class ImageServiceImpl implements ImageService {


    @Override
    public Result listImage() {
        String[] image = {
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/e2e1ca4f-9b09-4f9c-b620-1e164aaf68de.jpg",
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/9aacac11-3302-4d4f-93a3-6f2e09c3cd1a.jpg",
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/a2996a1f-c9ff-4712-b856-e28396b088e5.jpg",
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/4fc31da6-d157-454b-97f7-0962d44d1b2d.jpg",
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/be695a27-3b8d-44ce-9bd7-b79eab0f97c3.jpg",
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/e327dfdd-dc5c-42fc-8284-8968214992b6.jpg",
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/8e61a020-fe1c-4baa-9913-2faf2de210e8.jpg",
                "https://niit-zyj.oss-cn-beijing.aliyuncs.com/avatar/bf68716a-6da7-4246-be9e-00ec4b4ddb03.jpg"
        };
        List list = new ArrayList();
        for(int i = 0; i<image.length; i++){
            list.add(image[i]);
        }

        return Result.success(list);
    }
}
