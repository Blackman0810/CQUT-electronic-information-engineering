%ʵ��Ҫ��һ�����׼�������ʾ
clear all; clc; close all;
[y,fs]=audioread('C3_4_y_1.wav');
plot(y,'k')
y=y(1:1000);
N=1024;                                                       % ����Ƶ�ʺ�FFT�ĳ���
len=length(y);
time=(0:len-1)/fs;                                         % ʱ��̶�
figure(1), subplot 311; plot(time,y,'k');           % �����źŲ���
title('(a)�źŲ���'); axis([0 max(time) -1 1]);
ylabel('��ֵ'); xlabel(['ʱ��/s' 10]); grid;

nn=1:N/2; ff=(nn-1)*fs/N;                       % ����Ƶ�ʿ̶�
z=Nrceps(y);                                            %��ȡ����
figure(1), subplot 312; plot(time,z,'k');       % ��������ͼ
title('(b)�źŵ���ͼ'); axis([0 time(512) -0.2 0.2]); grid; 
ylabel('��ֵ'); xlabel(['��Ƶ��/s' 10]);

yc=cceps(y);
yn=icceps(yc);
figure(1), subplot 313; plot(time,yn,'k');     % ��������ͼ
title('(c)�ָ��ź�'); axis([0 max(time) -1 1]);
ylabel('��ֵ'); xlabel(['ʱ��/s' 10]); grid;   

% ��ȡ������
zc = compceps(y);

% �ָ��ź�
yn_rec = icompceps(zc);

% ����������ͼ
figure(2), subplot 311; plot(time,abs(zc),'k');      % ���������׵ķ���ͼ
title('(d)�����׷���ͼ'); axis([0 time(512) -0.2 0.2]);
ylabel('��ֵ'); xlabel(['��Ƶ��/s' 10]); grid;

% �����ָ��ź�
figure(1), subplot 313; plot(time,yn_rec,'k');   % �����ָ��ź�
title('(c)�ָ��ź�'); axis([0 max(time) -1 1]);
ylabel('��ֵ'); xlabel(['ʱ��/s' 10]); grid;
% ��������غ�������
function ccep = compceps(x)
    N = length(x);
    X = fft(x);
    X_mag = abs(X);
    X_log = log(X_mag + eps);
    ccep = ifft(X_log);
end

function x_rec = icompceps(ccep)
    N = length(ccep);
    X_log = fft(ccep);
    X_rec = exp(X_log - log(N));
    x_rec = real(X_rec(1:N/2+1))/N;
end