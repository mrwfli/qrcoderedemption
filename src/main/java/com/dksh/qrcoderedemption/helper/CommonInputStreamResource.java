package com.dksh.qrcoderedemption.helper;

import org.springframework.core.io.InputStreamResource;

import java.io.InputStream;

public class CommonInputStreamResource extends InputStreamResource {
    private int length;

    public CommonInputStreamResource(InputStream inputStream) {
        super(inputStream);
    }

    public CommonInputStreamResource(InputStream inputStream, int length) {
        super(inputStream);
        this.length = length;
    }

    /**
     * 覆寫父類方法
     * 如果不重寫這個方法，並且檔案有一定大小，那麼服務端會出現異常
     * {@code The multi-part request contained parameter data (excluding uploaded files) that exceeded}
     *
     * @return
     */
    @Override
    public String getFilename() {
        return "temp";
    }

    /**
     * 覆寫父類 contentLength 方法
     * 因為 {@link org.springframework.core.io.AbstractResource#contentLength()}方法會重新讀取一遍檔案，
     * 而上傳檔案時，restTemplate 會通過這個方法獲取大小。然後當真正需要讀取內容的時候，發現已經讀完，會報如下錯誤。
     * <code>
     * java.lang.IllegalStateException: InputStream has already been read - do not use InputStreamResource if a stream needs to be read multiple times
     * at org.springframework.core.io.InputStreamResource.getInputStream(InputStreamResource.java:96)
     * </code>
     * <p>
     * ref:com.amazonaws.services.s3.model.S3ObjectInputStream#available()
     *
     * @return
     */
    @Override
    public long contentLength() {
        int estimate = length;
        return estimate == 0 ? 1 : estimate;
    }
}