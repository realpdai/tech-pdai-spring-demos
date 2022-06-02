/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tech.pdai.springboot.elasticjob.lite.controller;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.OneOffJobBootstrap;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.elasticjob.lite.entity.response.ResponseResult;

/**
 * 这里需要加上@Lazy, 请看这个issue:https://github.com/apache/shardingsphere-elasticjob/issues/2014
 */
@Lazy
@RestController
public class OneOffJobController {

    @Resource(name = "occurErrorNoticeDingtalkBean")
    private OneOffJobBootstrap occurErrorNoticeDingtalkJob;

    @Resource(name = "occurErrorNoticeWechatBean")
    private OneOffJobBootstrap occurErrorNoticeWechatJob;

    @Resource(name = "occurErrorNoticeEmailBean")
    private OneOffJobBootstrap occurErrorNoticeEmailJob;

    @ApiOperation("Test occurErrorNoticeDingtalkJob")
    @GetMapping("/execute/occurErrorNoticeDingtalkJob")
    public ResponseResult<String> executeOneOffJob() {
        occurErrorNoticeDingtalkJob.execute();
        return ResponseResult.success();
    }

    @ApiOperation("Test executeOccurErrorNoticeWechatJob")
    @GetMapping("/execute/occurErrorNoticeWechatJob")
    public ResponseResult<String> executeOccurErrorNoticeWechatJob() {
        occurErrorNoticeWechatJob.execute();
        return ResponseResult.success();
    }

    @ApiOperation("Test executeOccurErrorNoticeEmailJob")
    @GetMapping("/execute/occurErrorNoticeEmailJob")
    public ResponseResult<String> executeOccurErrorNoticeEmailJob() {
        occurErrorNoticeEmailJob.execute();
        return ResponseResult.success();
    }
}
