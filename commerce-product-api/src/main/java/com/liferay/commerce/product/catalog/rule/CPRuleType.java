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

package com.liferay.commerce.product.catalog.rule;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPRule;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.UnicodeProperties;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Marco Leo
 */
@ProviderType
public interface CPRuleType {

	public void contributeDocument(Document document, CPDefinition cpDefinition)
		throws PortalException;

	public String getKey();

	public String getLabel(Locale locale);

	public UnicodeProperties getTypeSettingsProperties(
		HttpServletRequest httpServletRequest);

	public boolean isSatisfied(CPDefinition cpDefinition, CPRule cpRule)
		throws PortalException;

	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, CPRule cpRule)
		throws PortalException;

	public void update(CPRule cpRule, HttpServletRequest httpServletRequest)
		throws PortalException;

}