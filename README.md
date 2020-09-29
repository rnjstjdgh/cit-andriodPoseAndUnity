# 안드로이드 pose detection project
### Overview
1) (https://github.com/tensorflow/examples/tree/master/lite/examples/posenet/android) 를 참고한 프로젝트
2) andriod를 통해 pose를 detection후 이를 별도 서버로 전송할 수 있도록 버튼 및 ftp모듈 추가
![Demo Image](posenetimage.png)
3) 실시간으로 전송되는 pose 좌표를 다양하게 활용가능 할 것으로 기대

### Architecture


1) 전체 설계
 ![image](https://user-images.githubusercontent.com/41561652/94516669-47865000-0261-11eb-8df1-cf0f2aa2c9a4.png)

2) TLF PoseNet설계
![image](https://user-images.githubusercontent.com/41561652/94516749-7c92a280-0261-11eb-924b-fe52af27bc98.png)



### Additional Note

 1)
 ![image](https://user-images.githubusercontent.com/41561652/90605876-ed45a880-e239-11ea-9716-0e902fe48cf7.png)

CameraActivity의 FTP전송 코드에서 ip주소, 포트번호, 계정 정보 입력하면 해당 서버로 안드로이드에서 촬영한 포즈 좌표가 json 형태로 넘어간다.
 
  2) ftp모듈은 ftp4j-1.7.2'를 프로젝트 자체에 받아서 사용함
  
  3) 로컬에서 json파일을 만든 후 버튼 이벤트를 통해 서버로 전송하도록 구현

