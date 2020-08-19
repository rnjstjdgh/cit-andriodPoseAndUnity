# 안드로이드 pose detection project
### Overview
1) (https://github.com/tensorflow/examples/tree/master/lite/examples/posenet/android) 를 참고한 프로젝트
2) andriod를 통해 pose를 detection후 이를 별도 서버로 전송할 수 있도록 버튼 및 ftp모듈 추가
![Demo Image](posenetimage.png)
3) 실시간으로 전송되는 pose 좌표를 다양하게 활용가능 할 것으로 기대
4) 기본 빌드 과정은 아래와 같음

## Build the demo using Android Studio

### Prerequisites

* If you don't have it already, install **[Android Studio](
 https://developer.android.com/studio/index.html)** 3.2 or
 later, following the instructions on the website.

* Android device and Android development environment with minimum API 21.

### Building
* Open Android Studio, and from the `Welcome` screen, select
`Open an existing Android Studio project`.

* From the `Open File or Project` window that appears, navigate to and select
 the `tensorflow-lite/examples/posenet/android` directory from wherever you
 cloned the TensorFlow Lite sample GitHub repo. Click `OK`.

* If it asks you to do a `Gradle Sync`, click `OK`.

* You may also need to install various platforms and tools, if you get errors
 like `Failed to find target with hash string 'android-21'` and similar. Click
 the `Run` button (the green arrow) or select `Run` > `Run 'android'` from the
 top menu. You may need to rebuild the project using `Build` > `Rebuild Project`.

* If it asks you to use `Instant Run`, click `Proceed Without Instant Run`.

* Also, you need to have an Android device plugged in with developer options
 enabled at this point. See **[here](
 https://developer.android.com/studio/run/device)** for more details
 on setting up developer devices.


### Model used
Downloading, extraction and placement in assets folder has been managed
 automatically by `download.gradle`.

If you explicitly want to download the model, you can download it from
 **[here](
 https://storage.googleapis.com/download.tensorflow.org/models/tflite/posenet_mobilenet_v1_100_257x257_multi_kpt_stripped.tflite)**.

### Additional Note
_Please do not delete the assets folder content_. If you explicitly deleted the
 files, then please choose `Build` > `Rebuild` from menu to re-download the
 deleted model files into assets folder.
 
 ![image](https://user-images.githubusercontent.com/41561652/90605876-ed45a880-e239-11ea-9716-0e902fe48cf7.png)

-> CameraActivity의 FTP전송 코드에서 ip주소, 포트번호, 계정 정보 입력하면 해당 서버로 안드로이드에서 촬영한 포즈 좌표가 json 형태로 넘어간다.
 

