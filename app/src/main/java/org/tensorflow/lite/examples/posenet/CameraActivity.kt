/*
 * Copyright 2019 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.posenet

import android.os.Bundle
import android.provider.Settings
import android.provider.Telephony.Carriers.PORT
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import it.sauronsoftware.ftp4j.FTPClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.tensorflow.lite.examples.posenet.Global.CurrentState
import org.tensorflow.lite.examples.posenet.Global.OutPutString
import java.io.File

class CameraActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.tfe_pn_activity_camera)
    savedInstanceState ?: supportFragmentManager.beginTransaction()
      .replace(R.id.container, PosenetActivity())
      .commit()

    val eventBtn = findViewById<Button>(R.id.button)
    eventBtn.setOnClickListener{
      if(eventBtn.text == "waiting"){
        //wating 상태에서 collectPose상태로 이동하는 상황
        OutPutString.btnEventOutStr = ""
        CurrentState.state = "collectPose"
        eventBtn.text = "collectPose"
      }
      else{
        //collectPose 상태에서 wating 상태로 이동하는 상황

        //1) SendDataResult.txt파일을 json으로 가공해서 서버로 전송(지금은 로컬에 출력하자)
        var sendPoseData = "[" + OutPutString.btnEventOutStr
        sendPoseData = sendPoseData.substring(0,sendPoseData.lastIndex-1) + "]"

        val sendDataFile = File("/data/user/0/org.tensorflow.lite.examples.posenet/files","SendDataResult.json")
        if (!sendDataFile.exists())
          sendDataFile.createNewFile()
        sendDataFile.writeText(sendPoseData)

        GlobalScope.launch {
          //1-1) ftp파일 업로드 시도해보자
          try {
            val mFtpClient = FTPClient()
            mFtpClient.connect("IP address", "port")
            mFtpClient.login("user", "password")
            mFtpClient.type = FTPClient.TYPE_BINARY
            mFtpClient.changeDirectory("/ridersTest/")

            mFtpClient.upload(File("/data/user/0/org.tensorflow.lite.examples.posenet/files/SendDataResult.json"))
            mFtpClient.disconnect(true)

          } catch (e: Exception) {
            e.printStackTrace()
          }
        }

        //2) 다시 대기상태로 이동
        CurrentState.state = "waiting"
        eventBtn.text = "waiting"
      }
    }

  }
}
