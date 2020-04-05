package com.wzeqiu.apptest.http.bean

class HistoryBean {
    /**
     * resource_id : a807b7ab-6cad-4aa6-87d0-e283a7353a0f
     * fields : [{"type":"int4","id":"_id"},{"type":"text","id":"quarter"},{"type":"numeric","id":"volume_of_mobile_data"}]
     * records : [{"volume_of_mobile_data":"0.171586","quarter":"2008-Q1","_id":15},{"volume_of_mobile_data":"0.248899","quarter":"2008-Q2","_id":16},{"volume_of_mobile_data":"0.439655","quarter":"2008-Q3","_id":17},{"volume_of_mobile_data":"0.683579","quarter":"2008-Q4","_id":18},{"volume_of_mobile_data":"19.97554729","quarter":"2018-Q3","_id":57},{"volume_of_mobile_data":"20.43921113","quarter":"2018-Q4","_id":58}]
     * _links : {"start":"/api/action/datastore_search?limit=44&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f","next":"/api/action/datastore_search?offset=58&limit=44&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f"}
     * offset : 14
     * limit : 44
     * total : 59
     */
    var resource_id: String? = null
    private var _links: LinksBean? = null
    var offset = 0
    var limit = 0
    var total = 0
    var fields: List<FieldsBean>? = null
    var records: List<RecordsBean>? = null

    fun get_links(): LinksBean? {
        return _links
    }

    fun set_links(_links: LinksBean?) {
        this._links = _links
    }

    override fun toString(): String {
        return "HistoryBean(resource_id=$resource_id, _links=$_links, offset=$offset, limit=$limit, total=$total, fields=$fields, records=$records)"
    }

    class LinksBean {
        /**
         * start : /api/action/datastore_search?limit=44&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f
         * next : /api/action/datastore_search?offset=58&limit=44&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f
         */
        var start: String? = null
        var next: String? = null
        override fun toString(): String {
            return "LinksBean(start=$start, next=$next)"
        }


    }

    class FieldsBean {
        /**
         * type : int4
         * id : _id
         */
        var type: String? = null
        var id: String? = null
        override fun toString(): String {
            return "FieldsBean(type=$type, id=$id)"
        }


    }

    class RecordsBean {
        /**
         * volume_of_mobile_data : 0.171586
         * quarter : 2008-Q1
         * _id : 15
         */
        var volume_of_mobile_data: String? = null
        var quarter: String? = null
        private var _id = 0

        fun get_id(): Int {
            return _id
        }

        fun set_id(_id: Int) {
            this._id = _id
        }

        override fun toString(): String {
            return "RecordsBean(volume_of_mobile_data=$volume_of_mobile_data, quarter=$quarter, _id=$_id)"
        }


    }



}