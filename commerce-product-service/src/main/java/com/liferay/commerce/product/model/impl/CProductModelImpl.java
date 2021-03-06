/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.product.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.model.CProductModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CProduct service. Represents a row in the &quot;CProduct&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CProductModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CProductImpl}.
 * </p>
 *
 * @author Marco Leo
 * @see CProductImpl
 * @generated
 */
@ProviderType
public class CProductModelImpl
	extends BaseModelImpl<CProduct> implements CProductModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a c product model instance should use the <code>CProduct</code> interface instead.
	 */
	public static final String TABLE_NAME = "CProduct";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"externalReferenceCode", Types.VARCHAR},
		{"CProductId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"publishedCPDefinitionId", Types.BIGINT},
		{"latestVersion", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalReferenceCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("CProductId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("publishedCPDefinitionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("latestVersion", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CProduct (uuid_ VARCHAR(75) null,externalReferenceCode VARCHAR(75) null,CProductId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,publishedCPDefinitionId LONG,latestVersion INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table CProduct";

	public static final String ORDER_BY_JPQL =
		" ORDER BY cProduct.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CProduct.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.product.model.CProduct"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.product.model.CProduct"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.product.model.CProduct"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long EXTERNALREFERENCECODE_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	public static final long CREATEDATE_COLUMN_BITMASK = 16L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.product.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.product.model.CProduct"));

	public CProductModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _CProductId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCProductId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _CProductId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CProduct.class;
	}

	@Override
	public String getModelClassName() {
		return CProduct.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CProduct, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CProduct, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CProduct, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((CProduct)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CProduct, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CProduct, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CProduct)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CProduct, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CProduct, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<CProduct, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CProduct, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CProduct, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<CProduct, Object>>();
		Map<String, BiConsumer<CProduct, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<CProduct, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object uuid) {
					cProduct.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"externalReferenceCode",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getExternalReferenceCode();
				}

			});
		attributeSetterBiConsumers.put(
			"externalReferenceCode",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(
					CProduct cProduct, Object externalReferenceCode) {

					cProduct.setExternalReferenceCode(
						(String)externalReferenceCode);
				}

			});
		attributeGetterFunctions.put(
			"CProductId",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getCProductId();
				}

			});
		attributeSetterBiConsumers.put(
			"CProductId",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object CProductId) {
					cProduct.setCProductId((Long)CProductId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object groupId) {
					cProduct.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object companyId) {
					cProduct.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object userId) {
					cProduct.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object userName) {
					cProduct.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object createDate) {
					cProduct.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object modifiedDate) {
					cProduct.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"publishedCPDefinitionId",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getPublishedCPDefinitionId();
				}

			});
		attributeSetterBiConsumers.put(
			"publishedCPDefinitionId",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(
					CProduct cProduct, Object publishedCPDefinitionId) {

					cProduct.setPublishedCPDefinitionId(
						(Long)publishedCPDefinitionId);
				}

			});
		attributeGetterFunctions.put(
			"latestVersion",
			new Function<CProduct, Object>() {

				@Override
				public Object apply(CProduct cProduct) {
					return cProduct.getLatestVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"latestVersion",
			new BiConsumer<CProduct, Object>() {

				@Override
				public void accept(CProduct cProduct, Object latestVersion) {
					cProduct.setLatestVersion((Integer)latestVersion);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public String getExternalReferenceCode() {
		if (_externalReferenceCode == null) {
			return "";
		}
		else {
			return _externalReferenceCode;
		}
	}

	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		_columnBitmask |= EXTERNALREFERENCECODE_COLUMN_BITMASK;

		if (_originalExternalReferenceCode == null) {
			_originalExternalReferenceCode = _externalReferenceCode;
		}

		_externalReferenceCode = externalReferenceCode;
	}

	public String getOriginalExternalReferenceCode() {
		return GetterUtil.getString(_originalExternalReferenceCode);
	}

	@Override
	public long getCProductId() {
		return _CProductId;
	}

	@Override
	public void setCProductId(long CProductId) {
		_CProductId = CProductId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getPublishedCPDefinitionId() {
		return _publishedCPDefinitionId;
	}

	@Override
	public void setPublishedCPDefinitionId(long publishedCPDefinitionId) {
		_publishedCPDefinitionId = publishedCPDefinitionId;
	}

	@Override
	public int getLatestVersion() {
		return _latestVersion;
	}

	@Override
	public void setLatestVersion(int latestVersion) {
		_latestVersion = latestVersion;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CProduct.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CProduct.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CProduct toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CProduct)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CProductImpl cProductImpl = new CProductImpl();

		cProductImpl.setUuid(getUuid());
		cProductImpl.setExternalReferenceCode(getExternalReferenceCode());
		cProductImpl.setCProductId(getCProductId());
		cProductImpl.setGroupId(getGroupId());
		cProductImpl.setCompanyId(getCompanyId());
		cProductImpl.setUserId(getUserId());
		cProductImpl.setUserName(getUserName());
		cProductImpl.setCreateDate(getCreateDate());
		cProductImpl.setModifiedDate(getModifiedDate());
		cProductImpl.setPublishedCPDefinitionId(getPublishedCPDefinitionId());
		cProductImpl.setLatestVersion(getLatestVersion());

		cProductImpl.resetOriginalValues();

		return cProductImpl;
	}

	@Override
	public int compareTo(CProduct cProduct) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), cProduct.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CProduct)) {
			return false;
		}

		CProduct cProduct = (CProduct)obj;

		long primaryKey = cProduct.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CProductModelImpl cProductModelImpl = this;

		cProductModelImpl._originalUuid = cProductModelImpl._uuid;

		cProductModelImpl._originalExternalReferenceCode =
			cProductModelImpl._externalReferenceCode;

		cProductModelImpl._originalGroupId = cProductModelImpl._groupId;

		cProductModelImpl._setOriginalGroupId = false;

		cProductModelImpl._originalCompanyId = cProductModelImpl._companyId;

		cProductModelImpl._setOriginalCompanyId = false;

		cProductModelImpl._setModifiedDate = false;

		cProductModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CProduct> toCacheModel() {
		CProductCacheModel cProductCacheModel = new CProductCacheModel();

		cProductCacheModel.uuid = getUuid();

		String uuid = cProductCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			cProductCacheModel.uuid = null;
		}

		cProductCacheModel.externalReferenceCode = getExternalReferenceCode();

		String externalReferenceCode = cProductCacheModel.externalReferenceCode;

		if ((externalReferenceCode != null) &&
			(externalReferenceCode.length() == 0)) {

			cProductCacheModel.externalReferenceCode = null;
		}

		cProductCacheModel.CProductId = getCProductId();

		cProductCacheModel.groupId = getGroupId();

		cProductCacheModel.companyId = getCompanyId();

		cProductCacheModel.userId = getUserId();

		cProductCacheModel.userName = getUserName();

		String userName = cProductCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			cProductCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			cProductCacheModel.createDate = createDate.getTime();
		}
		else {
			cProductCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			cProductCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			cProductCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		cProductCacheModel.publishedCPDefinitionId =
			getPublishedCPDefinitionId();

		cProductCacheModel.latestVersion = getLatestVersion();

		return cProductCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CProduct, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CProduct, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CProduct, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CProduct)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CProduct, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CProduct, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CProduct, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CProduct)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		CProduct.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		CProduct.class, ModelWrapper.class
	};

	private String _uuid;
	private String _originalUuid;
	private String _externalReferenceCode;
	private String _originalExternalReferenceCode;
	private long _CProductId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _publishedCPDefinitionId;
	private int _latestVersion;
	private long _columnBitmask;
	private CProduct _escapedModel;

}