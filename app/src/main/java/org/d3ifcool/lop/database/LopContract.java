package org.d3ifcool.lop.database;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by CHEVALIER-11 on 24-Apr-18.
 */

public class LopContract {
    private LopContract(){}
    public static final String CONTENT_AUTHORITY = "org.d3ifcool.lop";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    public static final String PATH_TARGET = "targets";
    public static final String PATH_TIP = "tips";
    public static final String PATH_ACHIEVE = "achieves";

    public static final class TargetEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TARGET);

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_TARGET;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_TARGET;

        public final static String TABLE_NAME = "targets";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_TITLE = "name";
        public final static String COLUMN_DESC = "desc";
        public final static String COLUMN_STATUS = "status";

        public  final static int GENDER_MALE = 0;
        public  final static int GENDER_FEMALE = 1;

        public  final static int COMPLETED_STATUS = 1;
        public  final static int ONPROGRESS_STATUS = 2;
        public  final static int FAILED_STATUS = 0;
        public  final static int LOCKED_STATUS = -1;

    }

    public static final class TipsEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_TIP);

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_TIP;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_TIP;

        public final static String TABLE_NAME = "tips";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_TITLE = "name";
        public final static String COLUMN_DESC = "desc";
        public final static String COLUMN_STATUS = "status";

        public  final static int COMPLETED_STATUS = 1;
        public  final static int ONPROGRESS_STATUS = 2;
        public  final static int FAILED_STATUS = 0;
        public  final static int LOCKED_STATUS = -1;

    }

    public static final class AchievesEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_ACHIEVE);

        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_ACHIEVE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
                + "/" + CONTENT_AUTHORITY + "/" + PATH_ACHIEVE;

        public final static String TABLE_NAME = "achieves";

        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_TITLE = "name";
        public final static String COLUMN_DESC = "desc";
        public final static String COLUMN_TARGET_CONDITION = "target";
        public final static String COLUMN_TIP_CONDITION = "tip";
        public final static String COLUMN_STATUS = "status";

        public  final static int COMPLETED_STATUS = 1;
        public  final static int ONPROGRESS_STATUS = 2;
        public  final static int FAILED_STATUS = 0;
        public  final static int LOCKED_STATUS = -1;

    }
}
