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

package com.liferay.headless.commerce.admin.site.setting.resource.v1_0;

import com.liferay.headless.commerce.admin.site.setting.dto.v1_0.AvailabilityEstimate;
import com.liferay.portal.kernel.model.Company;

import javax.annotation.Generated;

import javax.ws.rs.core.Response;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-commerce-admin-site-setting/v1.0
 *
 * @author Zoltán Takács
 * @generated
 */
@Generated("")
public interface AvailabilityEstimateResource {

	public Response deleteAvailabilityEstimate(Long id) throws Exception;

	public Response getAvailabilityEstimate(Long id) throws Exception;

	public Response updateMediaType1AvailabilityEstimate(
			Long id, AvailabilityEstimate availabilityEstimate)
		throws Exception;

	public Response updateMediaType2AvailabilityEstimate(
			Long id, AvailabilityEstimate availabilityEstimate)
		throws Exception;

	public Response getAvailabilityEstimates(Long groupId) throws Exception;

	public Response upsertMediaType1AvailabilityEstimate(
			Long groupId, AvailabilityEstimate availabilityEstimate)
		throws Exception;

	public Response upsertMediaType2AvailabilityEstimate(
			Long groupId, AvailabilityEstimate availabilityEstimate)
		throws Exception;

	public void setContextCompany(Company contextCompany);

}