# asconf

0) certs env
we need write 'cmd' to /proc, so we must sign this apk. android-studio support auto sign,
read certs/HOWTOCERTS to configure it.

How to use this demo：
1) you should delete the conf file first, ie:
host$ adb root
host$ adb shell
phone# rm /storage/emulated/0/Podcasts/andd.conf

2) run app and click "写入"

3) then you can check config file write succeed, ie:
host$ adb root
host$ adb shell
phone# cat /storage/emulated/0/Podcasts/andd.conf

4) lastest, you can reboot device and check all config set succeed!
ie:
host$ adb root
host$ adb shell
phone# ifconfig | grep wlan0
then check HWaddr is same as wireless_mac that configed in /storage/emulated/0/Podcasts/andd.conf
