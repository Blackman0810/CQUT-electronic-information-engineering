clear all;
clc;

% ʹ��audioread��ȡ��Ƶ�ļ�
[x, fs] = audioread('C6_3_y.wav');
% ʹ��audioinfo��ȡ��Ƶ�ļ���Ϣ
info = audioinfo('C6_3_y.wav');
numbits = info.BitsPerSample;
sign_bit=2;                                     % ��λADPCM�㷨
ss=adpcm_encoder(x,sign_bit);
yy=adpcm_decoder(ss,sign_bit)';

% ����������
nq=sum((x-yy).^2)/length(x);

% �����ź�����
sq=mean(yy.^2);

% ���������
snr=(sq/nq);

% ʱ����
t=(1:length(x))/fs;

% ����ͼ��
subplot(211)
plot(t,x/max(abs(x)))
axis tight
title('(a)����ǰ����')
xlabel('ʱ��/s')
ylabel('����')

subplot(212)
plot(t,yy/max(abs(yy)))
axis tight
title('(b)���������')
xlabel('ʱ��/s')
ylabel('����')

% ���㲢��ʾ���������
snrq=10*log10(mean(snr));
disp(['Quantization SNR: ', num2str(snrq), ' dB']);